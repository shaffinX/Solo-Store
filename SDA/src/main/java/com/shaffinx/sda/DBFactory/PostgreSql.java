/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.DBFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author shaff
 */
public class PostgreSql implements Database{
    private String DRIVER;
    private String URL; // Update as needed
    private String USERNAME; // Update as needed
    private String PASSWORD; // Update as needed
    public PostgreSql(){
        try (FileInputStream fis = new FileInputStream("src/main/java/com/shaffinx/sda/DBFactory/connection.properties")) {
            Properties properties = new Properties();
            properties.load(fis);

            this.DRIVER = properties.getProperty("postgresql.driver");
            this.URL = properties.getProperty("postgresql.url");
            this.USERNAME = properties.getProperty("postgresql.username");
            this.PASSWORD = properties.getProperty("postgresql.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Connection connect() {
        try {
            Class.forName(DRIVER);
            System.out.println("Connecting to PostgreSQL...");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to PostgreSQL");
        }
    }

    @Override
    public void disconnect(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from PostgreSQL.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
