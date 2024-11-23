/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Orders;

/**
 *
 * @author shaff
 */
public class Orders {
    private String date;
    private int prodid;
    private int customerid;
    public Orders(String date,int prod_id,int cusid){
        this.date = date;
        this.prodid = prod_id;
        this.customerid = cusid;
    }
   
    public String getDate(){
        return this.date;
    }
    public int getProdId()
    {
        return this.prodid;
    }
    public int getCustomId()
    {
        return this.customerid;
    }
}
