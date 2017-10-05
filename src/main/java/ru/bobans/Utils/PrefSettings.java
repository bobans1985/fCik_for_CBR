package ru.bobans.Utils;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.prefs.Preferences;

/**
 * Created by GrishukovVM on 27.01.2016.
 */
public class PrefSettings  {
    String DEFAULTJDBCTHIN="";
    static final String DEFAULTOGRN="12324324";
    static final String DEFAULTINN="1234123123";
    static final String DEFAULTADRESS="123123, г. Москва, улица, дом 11";
    static final String DEFAULTNAME="Наименование Банка";
    static final String DEFAULTPHONE="7(111)111-11-11";
    static final String DEFAULTFIO="ФАМИЛИЯ ИМЯ ОТЧЕСТВО ПРОВЕРЯЮЩЕГО";
    static final String DEFAULTEMAIL="email@email.ru";
    static final String DIRFROM  = "dirfrom";
    static final String DIRTO  = "dirto";
    static final String DEFAULTDIR = new File(".").toString();
    static final String DEFAULTQUERY = "select 1 from dual";
    static final String DEFAULTCHECKFIO = "FALSE";
    //static final
    String DEFAULTJDBCUSER = "LOGIN";
    //static final
    String DEFAULTJDBCPASS = "PASSWORD";

    /*public void setDEFAULTJDBCUSER(String DEFAULTJDBCUSER) {
        this.DEFAULTJDBCUSER = DEFAULTJDBCUSER;
    }

    public void setDEFAULTJDBCPASS(String DEFAULTJDBCPASS) {
        this.DEFAULTJDBCPASS = DEFAULTJDBCPASS;
    }*/

    Preferences userPrefs = Preferences.userNodeForPackage(PrefSettings.class);
    Properties prf = new Properties();
    //InputStream cfgFile = PrefSettings.class.getClassLoader().getResourceAsStream("/config.properties");
    InputStream cfgFile = PrefSettings.class.getResourceAsStream("/config.properties");
    static final String ROOTNODEPREF = "fCik";

    public PrefSettings() throws IOException {
        this.userPrefs = Preferences.userRoot().node(ROOTNODEPREF);
        if(this.cfgFile!=null){
            prf.load(new InputStreamReader(cfgFile, "UTF-8"));
        } else {
            System.out.println("Sorry, unable to find file: config.properties, usage default value");
        }
    }

    public String GetDirFrom() {
        System.out.println("GetDirFrom = " + userPrefs.get(DIRFROM,DEFAULTDIR));
        return userPrefs.get(DIRFROM,DEFAULTDIR).length()>0 ? userPrefs.get(DIRFROM,DEFAULTDIR) :  DEFAULTDIR;
    }

    public String GetDirTo() {
        System.out.println("GetDirTo = " + userPrefs.get(DIRTO,DEFAULTDIR));
        return userPrefs.get(DIRTO,DEFAULTDIR).length()>0 ? userPrefs.get(DIRTO,DEFAULTDIR) :  DEFAULTDIR;
    }

    public void SetDirFrom(JFileChooser chooser) {
        System.out.println("SetDirFrom = " + (chooser.getSelectedFile()!=null ?  chooser.getSelectedFile().getParent() : "null, usage old dir") );
        if (chooser.getSelectedFile()!=null) {
            userPrefs.put(DIRFROM, chooser.getSelectedFile().getParent());
        }
    }

    public void SetDirTo(JFileChooser chooser) {
        System.out.println("SetDirTo = " + (chooser.getSelectedFile()!=null ?  chooser.getSelectedFile().getAbsolutePath() : "null, usage old dir") );
        if (chooser.getSelectedFile()!=null) {
            userPrefs.put(DIRTO, chooser.getSelectedFile().getAbsolutePath());
        }
    }

    public void SetDirFrom(String pathfrom) {
        userPrefs.put(DIRFROM,pathfrom);
    }

    public void SetDirTo(String pathto) {
        userPrefs.put(DIRTO,pathto);
    }

    public String GetOutputDir() {
        return  userPrefs.get("OutputDir", Paths.get("").toAbsolutePath().toString());
    }


    public String GetJDBCString() throws NoSuchFieldException,IllegalAccessException {
        return  userPrefs.get("JDBCTHIN",GetSettingsFromConfig("JDBCTHIN"));
    }

    public void  SetJDBCString(String jdbcstring) {
        userPrefs.put("JDBCTHIN",jdbcstring);
    }

    public String GetSettingsFromConfig(String NameSettings) throws NoSuchFieldException,IllegalAccessException {
        if (prf.getProperty(NameSettings.toUpperCase())!=null) {
            String SettingsValue =  prf.getProperty(NameSettings.toUpperCase());
            System.out.println("load settings "+ NameSettings.toUpperCase() + " from config file:" + SettingsValue);
        } else System.out.println("Sorry, unable to find settings in file: usage default value " + NameSettings.toUpperCase());
        Field field = PrefSettings.class.getDeclaredField("DEFAULT" + NameSettings.toUpperCase() );
        field.setAccessible(true);
        return prf.getProperty(NameSettings.toUpperCase(),(String)field.get(this));
    }


    public File getResource(String res_in) {
        File file = null;
        String resource = res_in;
        URL res = getClass().getResource(resource);
        if (res.toString().startsWith("jar:")) {
            try {
                InputStream input = getClass().getResourceAsStream(resource);

                file = File.createTempFile("tempfile", ".tmp");
                OutputStream out = new FileOutputStream(file);
                int read;
                byte[] bytes = new byte[1024];
                //new InputStreamReader(input, "UTF-8")
                while ((read = input.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                file.deleteOnExit();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            //this will probably work in your IDE, but not from a JAR
            file = new File(res.getFile());
        }

        if (file != null && !file.exists()) {
            throw new RuntimeException("Error: File " + file + " not found!");
        }
        return file;
    }


}
