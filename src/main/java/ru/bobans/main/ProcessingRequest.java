package ru.bobans.main;


import ru.bobans.Response.fcikResponse;
import ru.bobans.Utils.FcikValidationEventHandler;
import ru.bobans.Utils.JdbcConnection;
import ru.bobans.Utils.PrefSettings;
import ru.bobans.gui.ProcessingRequestForm;
import ru.bobans.map_obj.Fcik;
import ru.bobans.map_obj.FileNameObj;
import ru.bobans.map_obj.Файл;

import javax.swing.*;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessingRequest {
    public ProcessingRequest(ProcessingRequestForm parent,JdbcConnection connection) {
        try {
                int count=0;
                System.out.println("bobans@ fcik for cbr....");
                PrefSettings pref=new PrefSettings();
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                JFileChooser chooser = new JFileChooser(pref.GetDirFrom());
                chooser.setDialogTitle("Выберите файл запроса ЦИК");
                chooser.showOpenDialog(null);
                pref.SetDirFrom(chooser);
                File FileZapros = chooser.getSelectedFile();

                if ((chooser.getSelectedFile()!=null) && (FileZapros.isFile())) {
                    FileNameObj FileNameOfRequest = new FileNameObj(FileZapros.getName());
                    System.out.println(FileNameOfRequest);

                    JAXBContext jaxbContext = JAXBContext.newInstance(Файл.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    Файл zapros_form_file= (Файл)jaxbUnmarshaller.unmarshal(FileZapros);

                    //------------------- GENERATE OBJ  --------------------
                    System.out.println("Начало генерации объекта для файла ответа");

                    Файл.Запрос zapros = zapros_form_file.getЗапрос();
                    List<Файл.Персона> persons_from_zapros = zapros_form_file.getПерсона();

                    Файл file_xml_out = new Файл();
                    Файл.ИнфОрг inforg= new Файл.ИнфОрг();

                    boolean Flag_check_fio = Boolean.valueOf(pref.GetSettingsFromConfig("CHECKFIO"));
                    inforg.setАдрес(pref.GetSettingsFromConfig("ADRESS"));
                    inforg.setИНН(pref.GetSettingsFromConfig("INN"));
                    inforg.setНазвание(pref.GetSettingsFromConfig("NAME"));
                    inforg.setОГРН(pref.GetSettingsFromConfig("OGRN"));
                    inforg.setТелефон(pref.GetSettingsFromConfig("PHONE"));
                    inforg.setФИО(pref.GetSettingsFromConfig("FIO"));
                    inforg.setЭлПочта(pref.GetSettingsFromConfig("EMAIL"));

                    file_xml_out.setЗапрос(zapros);
                    file_xml_out.setИнфОрг(inforg);

                    //file_xml_out.setИдФайл(FileNameOfRequest.getFileName().substring(0,28));
                    file_xml_out.setТипИнф("ЦИКЦБ");
                    file_xml_out.setВерсФорм("1.0");
                    file_xml_out.setВерсПрог("4.0 std");

                    List<Файл.Персона> list_persons_result = new ArrayList<>();
                    Connection connect = connection.getConnection();

                   boolean Flag_not_null = false;
                   String infoResult = "";
                   for (Файл.Персона persona: persons_from_zapros) {
                        Файл.Персона persona_result = new Файл.Персона();
                            System.out.println("Progress: " + count++ + "/" + persons_from_zapros.size() + "(" + Math.round((double) count / persons_from_zapros.size() * 100) + "%)");
                            parent.setProgressBar((int)((double) count / persons_from_zapros.size() * 100));
                            if (connection != null) {
                                System.out.println("-----------------------------------------");
                                System.out.println("Start executing....");
                                fcikResponse fcikRs = new fcikResponse(connect,   zapros.getДата(),
                                                                                  persona.getПерсИнфо().getДокумент().getКодВидДок(),
                                                                                  persona.getПерсИнфо().getДокумент().getСерия(),
                                                                                  persona.getПерсИнфо().getДокумент().getНомер());
                                System.out.format("Count records=%d \r\n",fcikRs.getCount() );
                                Boolean flag=false;
                                List<Файл.Персона.Счета> list_accounts_result = new ArrayList<>();
                                for (Fcik fcik: fcikRs.getFcikList()) {
                                    if ( (!Flag_check_fio) ||
                                       ( (Flag_check_fio) && ( persona.getПерсИнфо().getФИОД().getФамилия().toUpperCase() == fcik.getLastName().toUpperCase() ) &&
                                         ( persona.getПерсИнфо().getФИОД().getИмя().toUpperCase() == fcik.getFirstName().toUpperCase() ) &&
                                         ( persona.getПерсИнфо().getФИОД().getОтчество().toUpperCase() == fcik.getMiddleName().toUpperCase() ) )
                                       )
                                        {
                                            Flag_not_null = true;
                                            flag = true;
                                            Файл.Персона.Счета.Счет account_result = new Файл.Персона.Счета.Счет();
                                            account_result.setВидСчета(fcik.getTypyOfAccount());
                                            account_result.setНомерСчета(fcik.getAccount());
                                            account_result.setОстаток(new BigDecimal(fcik.getOstt()));

                                            Файл.Персона.Счета.КредитОрг kreditorg_result = new Файл.Персона.Счета.КредитОрг();
                                            kreditorg_result.setКодСубКред(fcik.getKodOfCred());
                                            kreditorg_result.setНаимКредит(fcik.getNameOfCred());
                                            kreditorg_result.setНеконфАдрКред(fcik.getNekonfAdrOfCred());
                                            kreditorg_result.setКонфАдрКред(fcik.getKonfAdrOfCred());

                                            Файл.Персона.Счета accounts_result = new Файл.Персона.Счета();
                                            accounts_result.setИдСчета("GUID" + fcik.Account);
                                            accounts_result.setСчет(account_result);
                                            accounts_result.setКредитОрг(kreditorg_result);
                                            list_accounts_result.add(accounts_result);
                                            infoResult += String.format("ФИО: %s %s %s; Документ: %s %s %s Счет и его тип: %s %s \r\n",
                                                    persona.getПерсИнфо().getФИОД().getФамилия(),
                                                    persona.getПерсИнфо().getФИОД().getИмя(),
                                                    persona.getПерсИнфо().getФИОД().getОтчество(),
                                                    persona.getПерсИнфо().getДокумент().getКодВидДок(),
                                                    persona.getПерсИнфо().getДокумент().getСерия(),
                                                    persona.getПерсИнфо().getДокумент().getНомер(),
                                                    fcik.getAccount(), fcik.getTypyOfAccount());
                                        } else System.out.format("Не прошли проверку на совпадение ФИО %s!=%s %s!=%s %s!=%s  \r\n",
                                                                  persona.getПерсИнфо().getФИОД().getФамилия().toUpperCase(), fcik.getLastName().toUpperCase(),
                                                                  persona.getПерсИнфо().getФИОД().getИмя().toUpperCase(), fcik.getFirstName().toUpperCase(),
                                                                  persona.getПерсИнфо().getФИОД().getОтчество().toUpperCase(), fcik.getMiddleName().toUpperCase() );
                                }
                                if (flag) {
                                    persona_result.setСчета(list_accounts_result);
                                    persona_result.setПерсИнфо(persona.getПерсИнфо());
                                    persona_result.setИд(persona.getИд());
                                    persona_result.setСлужИнфо(persona.getСлужИнфо());
                                    list_persons_result.add(persona_result);
                                }

                            } else {
                                System.out.println("Failed to make connection!");
                            }

                    }
                    System.out.println("-----------------------------------------");
                    System.out.println("Result: \r\n" + infoResult);
                    file_xml_out.setПерсона(list_persons_result);

                    //------------------- OUT FILE --------------------
                    if (Flag_not_null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy_HHmmss");
                        String filename_out = "K" + (pref.GetSettingsFromConfig("OGRN")) + "_" + sdf.format(new Date()) + "_" + FileNameOfRequest.getTypeOfReqest() + "_" + FileNameOfRequest.getNumOfRequest();

                        file_xml_out.setИдФайл(filename_out); // bug fix

                        File file_out = new File(FileZapros.getParentFile() + "\\" + filename_out + ".xml");
                        System.out.println("OUT FILE NAME:" + file_out.toString());
                        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                        // output pretty printed
                        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        jaxbMarshaller.setProperty("jaxb.noNamespaceSchemaLocation", "VO_CIK_CB_7.xsd");
                        jaxbMarshaller.marshal(file_xml_out, file_out);
                        System.out.println("End generate file response");


                        System.out.println("Начало валидации файла ответа по xsd схеме");
                        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                        Schema schema = sf.newSchema(new StreamSource(ProcessingRequest.class.getResourceAsStream("/VO_CIK_CB_7.xsd")));
                        jaxbMarshaller.setSchema(schema);
                        FcikValidationEventHandler validator = new FcikValidationEventHandler();
                        jaxbMarshaller.setEventHandler(validator);
                        jaxbMarshaller.marshal(file_xml_out, System.out);
                        System.out.println("Конец валидации. Количество ошибок валидации:" + validator.getCount());
                        if (validator.getCount() > 0) {
                             JOptionPane.showMessageDialog(null, "Были обнаруженны ошибки валидации по схеме. Количество ошибок: " + validator.getCount() + validator.getError());
                        }
                        JOptionPane.showMessageDialog(null, "По входящему запросу: " + FileNameOfRequest.getFileName() + " были найдены \"персоны\" для выгрузки! \r\nБыл сформирован файл-ответ: " + file_out.getAbsolutePath()  + " \r\nКоличество ошибок валидации: " + validator.getCount());

                    } else JOptionPane.showMessageDialog(null, "По паспортным данным из запроса в АБС ничего не найдено...");

                } else JOptionPane.showMessageDialog(null, "Нечего делать... ");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Произошла непредвиденная ошибка  " + ex.toString());
                ex.printStackTrace();
        }


    }

}
