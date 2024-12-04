/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Cart;

/**
 *
 * @author shaff
 */
public class CartSingleton {
    private static Cart instance;
    private CartSingleton(){
        
    }

    public static Cart getInstance()
    {
        if (instance == null) {
            synchronized (CartSingleton.class) {
                if (instance == null) {
                    instance = new Cart();
                }
            }
        }
        return instance;
    }
}
