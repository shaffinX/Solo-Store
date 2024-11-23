/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.DBFactory;
import com.shaffinx.sda.DBFactory.DataBaseFactory;
import com.shaffinx.sda.DBFactory.Database;
import com.shaffinx.sda.DBFactory.exec;
import java.sql.Connection;
/**
 *
 * @author shaff
 */
public class ExecSingleton {
    private static exec instance;

    private ExecSingleton() {
        // Private constructor to prevent instantiation
    }

    public static exec getInstance() {
        if (instance == null) {
            synchronized (ExecSingleton.class) {
                if (instance == null) {
                    try {
                        // Initialize the database connection
                        Database db = DataBaseFactory.getDatabase("postgres");
                        Connection connection = db.connect();
                        instance = new exec(connection);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to initialize Exe");
                    }
                }
            }
        }
        return instance;
    }
}
