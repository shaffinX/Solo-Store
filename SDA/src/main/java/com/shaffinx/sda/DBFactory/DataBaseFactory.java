/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.DBFactory;

/**
 *
 * @author shaff
 */
public class DataBaseFactory {
    public static Database getDatabase(String type) {
        if ("Postgres".equalsIgnoreCase(type)) {
            return new PostgreSql();
        } 
        throw new IllegalArgumentException("Unsupported database type: " + type);
    }
}
