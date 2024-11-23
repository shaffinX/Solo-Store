/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda;

/**
 *
 * @author shaff
 */
public class OrderModel {
    private String order_id;
    private String name;
    private String date;
    private String price;
    public OrderModel(int id,String name,String date,int price)
    {
        this.order_id = String.valueOf(id);
        this.name = name;
        this.date = date;
        this.price = String.valueOf(price);
    }
    public String getOrder_id(){
        return order_id;
    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getPrice(){
        return price;
    }
}
