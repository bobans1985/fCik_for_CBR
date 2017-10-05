package ru.bobans.Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by GrishukovVM on 08.07.2016.
 */
public class JdbcConnection {
    public Connection connection = null;

    public JdbcConnection() {}
    public void StartConnect(String user,String pass) throws IOException,IllegalAccessException,NoSuchFieldException  {
        System.out.println("-------- Oracle JDBC Connection ------");

        PrefSettings pref = new PrefSettings();
        String jdbcString = pref.GetJDBCString();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
         catch( ClassNotFoundException e )
         {
            System.out.println("Oracle JDBC Driver not found");
            e.printStackTrace();
         }

        System.out.print("Oracle JDBC Driver found. Version: ");
        try {
            connection = DriverManager.getConnection(jdbcString, user, pass);
            System.out.print(connection.getMetaData().getDriverVersion() + "\r\nConnection successful!\r\n");
        }
        catch( SQLException e )
        {
            System.out.println("Connection Failed!" + e);
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
