package com.example.adro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBaseConnect {
    private static String HOST = "127.0.0.1";
    private static int PORT = 3306;
    private static String DB_NAME = "adro";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static Connection connection;

    public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  connection;
    }

    public static void insertData(String sql) throws SQLException {
        Statement statement = getConnect().createStatement();
        if (statement.executeUpdate(sql)>0){
            System.out.println("Successfully added!");
        }else{
            System.out.println("Something went wrong!!!");
        }
    }
}
