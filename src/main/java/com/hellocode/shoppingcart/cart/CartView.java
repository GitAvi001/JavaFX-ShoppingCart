package com.hellocode.shoppingcart.cart;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CartView {

    public CartView() throws MalformedException, IOException {

        URL uifile=new File("/Users/avindu/Desktop/shopping-cart/src/main/java/com/hellocode/shoppingcart/cart/").toURI().toURL();

        FXMLLoader root=FXMLLoader.load(uifile);

    }

    public Parent getView(){
        return this.view=root;
    }

}
