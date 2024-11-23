/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda;

public class ProductModel {
    private String prod_id;
    private String name;
    private String description;
    private String price;
    public ProductModel(int id,String name,String description,int price)
    {
        this.prod_id = String.valueOf(id);
        this.name = name;
        this.description = description;
        this.price = String.valueOf(price);
    }
    public String getProd_id(){
        return prod_id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getPrice(){
        return price;
    }
}
