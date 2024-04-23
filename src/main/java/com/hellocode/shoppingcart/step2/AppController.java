package com.hellocode.shoppingcart.step2;


import com.hellocode.shoppingcart.cart.CartView;
import com.hellocode.shoppingcart.step2.home.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AppController {

    @FXML
    private BorderPane contentPane;

    public void closeApp(){
        App.getWindow().close();
    }

    public void showHomeView() throws IOException {
        contentPane.setCenter(new HomeView().getView());
    }

    public void showCartView(){
        contentPane.setCenter(new Label(new CartView().getView()));
    }
}
