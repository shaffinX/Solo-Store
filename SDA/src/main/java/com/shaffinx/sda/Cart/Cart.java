/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Cart;
import com.shaffinx.sda.Browse.pdisp;
import java.util.ArrayList;
import com.shaffinx.sda.Browse.pdisp;
public class Cart {
    ArrayList<pdisp> items;
    public Cart(){
        items= new ArrayList<pdisp>();
    }
    public void addToCart(pdisp itm){
        items.add(itm);
    }
    public void delete(){
        items = null;
    }
    public ArrayList<pdisp> getCart(){
        return items;
    }
    
}
