/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Browse;
import com.shaffinx.sda.Browse.pdisp;

/**
 *
 * @author shaff
 */
public class ProdSingleton {
    private static volatile pdisp instance; // Ensure visibility in multithreaded environments

    private ProdSingleton() {
        // Private constructor to prevent instantiation
    }

    public static pdisp getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (ProdSingleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new pdisp();
                }
            }
        }
        return instance;
    }
}