/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.DBFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author shaff
 */
public class exec {
    private final Connection connection;
    public exec(Connection conn){
        this.connection=conn;
    }
    public boolean Update(String query){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.err.println("Error executing query: " + query);
            e.printStackTrace();
            return false;
        }
    }
    public ResultSet Get(String query) throws SQLException{
        Statement statement = connection.createStatement(); // Do not use try-with-resources here
        return statement.executeQuery(query);
    }

}
