package utils;

import javax.swing.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
    private static final String DB_USER = getPropertiesValue("connection.userName");
    private static final String DB_PASSWORD = getPropertiesValue("connection.userPassword");
    private static final String DB_URL = getPropertiesValue("connection.URL");
    private static final String DB_DRIVER = getPropertiesValue("connection.mySql.driver");
    private static final String PROPERTIES_FILE = "connection.properties";

    public JDBCConnection() {
    }

    public static Connection getConnection(){
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

//
//
    private static String getPropertiesValue(String value){
        Properties properties = new Properties();
        try (InputStream inFile = JDBCConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)){
            properties.load(inFile);
            String result = properties.getProperty(value);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
