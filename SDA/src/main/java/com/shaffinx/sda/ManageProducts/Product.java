/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.ManageProducts;

public class Product {
    private String pname;
    private String pdesc;
    private String imgPath;
    private int price;
    private int storeId;
    public Product(String name,String desc,String path,int stid,int price){
        this.pname= name;
        this.pdesc = desc;
        this.imgPath =path;
        this.storeId = stid;
        this.price=price;
    }
    public String getName(){
        return this.pname;
    }
    public String getDesc(){
        return this.pdesc;
    }
    public String getImg(){
        return this.imgPath;
    }
    public int getstID(){
        return this.storeId;
    }
     public int getPrice(){
        return this.price;
    }
}
