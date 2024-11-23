/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Session;

/**
 *
 * @author shaff
 */
public class SessionSingelton {
    private static Session instance;
    private SessionSingelton(){
        
    }

    public static Session getInstance()
    {
        if (instance == null) {
            synchronized (SessionSingelton.class) {
                if (instance == null) {
                    instance = new Session();
                }
            }
        }
        return instance;
    }
}
