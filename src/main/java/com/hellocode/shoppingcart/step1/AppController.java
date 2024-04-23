package com.hellocode.shoppingcart.step1;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AppController {

    @FXML
    private BorderPane contentPane;

    public void closeApp(){
        App.getWindow().close();
    }

    public void showHomeView(){
        contentPane.setCenter(new Label("Home View"));
    }

    public void showCartView(){
        contentPane.setCenter(new Label("Cart View"));
    }
}
