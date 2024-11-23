/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.DBFactory;
import java.sql.Connection;
/**
 *
 * @author shaff
 */
public interface Database {
    Connection connect();
    void disconnect(Connection connection);
}
