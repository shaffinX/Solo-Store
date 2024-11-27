
/*

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
/*package com.shaffinx.sda;

*/

package com.shaffinx.sda;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import com.shaffinx.sda.ManageProducts.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeController {
    @FXML
    private TextField searchField; // The search bar
    @FXML
    private ListView<String> productListView; // List to display search results
    
    @FXML
    private void Account(MouseEvent event)throws IOException {
        Session s = SessionSingelton.getInstance();
        if("customer".equals(s.role)){
            App.setRoot("ProfileC");
        }
        if("store".equals(s.role)){
            App.setRoot("ProfileS");
        }
         
    }
    
    
    @FXML
    private void Cart(MouseEvent event) {
        System.out.println("Cart");
    }

    private ProductController productController = new ProductController();

    @FXML
    public void handleSearch() {
        String keyword = searchField.getText().trim();
        int storeId = 1; // Example: Use the current store's ID

        if (keyword.isEmpty()) {
            productListView.getItems().clear();
            productListView.getItems().add("Please enter a search keyword.");
            return;
        }

        ResultSet resultSet = productController.Search(keyword, storeId);

        ObservableList<String> products = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                String productName = resultSet.getString("prodname");
                int price = resultSet.getInt("price");
                products.add(productName + " - Rs. " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            products.add("Error loading search results.");
        }

        productListView.setItems(products);
    }
}
