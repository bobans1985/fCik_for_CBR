package ru.bobans.main;

import ru.bobans.Utils.FcikValidationEventHandler;
import ru.bobans.Utils.JdbcConnection;
import ru.bobans.Utils.PrefSettings;
import ru.bobans.gui.MainForm;
import ru.bobans.gui.ProcessingRequestForm;
import ru.bobans.map_obj.FileKvit;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessingReceipt {
    public ProcessingReceipt(JdbcConnection connection, String kod_receipt, String acknowledgementtype, String result_text) {
        try {
            System.out.println("bobans@ fcik for cbr....");
            PrefSettings pref=new PrefSettings();

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFileChooser chooser = new JFileChooser(pref.GetDirFrom());
            chooser.setDialogTitle("Выберите файл запроса ЦИК для которого нужно сформировать квитанцию");
            chooser.showOpenDialog(null);
            pref.SetDirFrom(chooser);
            java.io.File FileZapros = chooser.getSelectedFile();
            if ((chooser.getSelectedFile()!=null) && (FileZapros.isFile())) {
                FileNameObj FileNameOfRequest = new FileNameObj(FileZapros.getName());
                System.out.println(FileNameOfRequest);
                JAXBContext jaxbContext = JAXBContext.newInstance(Файл.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                //Файл zapros_form_file = (Файл) jaxbUnmarshaller.unmarshal(FileZapros); не нужно это нам
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy_HHmmss");
                String filename_out = "K" + (pref.GetSettingsFromConfig("OGRN")) + "_" + sdf.format(new Date()) + "_K_" + FileNameOfRequest.getNumOfRequest() + "_" + kod_receipt + "_" + "K" + (pref.GetSettingsFromConfig("OGRN"));


                //------------------- GENERATE OBJ  --------------------
                FileKvit file_xml_out = new FileKvit();
                file_xml_out.setAcknowledgementType(acknowledgementtype);
                file_xml_out.setResultCode(kod_receipt);
                file_xml_out.setResultText(result_text);
                file_xml_out.setTo(FileNameOfRequest.getIdSender());
                file_xml_out.setFrom("K" + (pref.GetSettingsFromConfig("OGRN")));
                file_xml_out.setMessageID(filename_out);
                file_xml_out.setCorrelationMessageID(FileNameOfRequest.getFileName().substring(0,28));
                file_xml_out.setMessageType("2");
                file_xml_out.setPriority("5");
                sdf = new SimpleDateFormat("dd.MM.yyyy");
                file_xml_out.setCreateTime(sdf.format(new Date()));

                java.io.File file_out = new java.io.File(FileZapros.getParentFile() + "\\" + filename_out + ".xml");
                System.out.println("OUT FILE NAME:" + file_out.toString());

                jaxbContext = JAXBContext.newInstance(FileKvit.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty("jaxb.noNamespaceSchemaLocation", "VO_CIK_CB_K_6.xsd");
                jaxbMarshaller.marshal(file_xml_out, file_out);
                System.out.println("End generate file response");

                System.out.println("Начало валидации файла-квитанции по xsd схеме");
                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = sf.newSchema(new StreamSource(ProcessingReceipt.class.getResourceAsStream("/VO_CIK_CB_K_6.xsd")));
                jaxbMarshaller.setSchema(schema);
                FcikValidationEventHandler validator = new FcikValidationEventHandler();
                jaxbMarshaller.setEventHandler(validator);
                jaxbMarshaller.marshal(file_xml_out, System.out);
                System.out.println("Конец валидации. Количество ошибок валидации:" + validator.getCount());
                JOptionPane.showMessageDialog(null, "Был сформирован файл-квитанция: " + file_out.getAbsolutePath()  + " \r\nКоличество ошибок валидации: " + validator.getCount());

            } else JOptionPane.showMessageDialog(null, "Нечего делать... ");

        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Произошла непредвиденная ошибка  " + ex.toString());
            ex.printStackTrace();
        }

    }
}
