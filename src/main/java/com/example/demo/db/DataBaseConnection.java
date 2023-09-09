package com.example.demo.db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author im_na
 */
public class DataBaseConnection {
    private static DataBaseConnection handler=null;
    private static Connection conn = null;

    private DataBaseConnection(){
        createConnection();
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/exel","root","naw441az@$@98");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static DataBaseConnection getInstance() {
        if ( handler==null){
            handler = new DataBaseConnection();
        }
        return handler;
    }

}
