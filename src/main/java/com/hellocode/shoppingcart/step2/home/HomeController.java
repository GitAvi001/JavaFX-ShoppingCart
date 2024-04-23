package com.hellocode.shoppingcart.step2.home;

import com.hellocode.shoppingcart.cart.ShoppingCart;
import com.hellocode.shoppingcart.step2.domain.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeController {
    Vbox productView1=productView(Product.APPLE);
    @FXML
    private GridPane productGridPane;

    public HomeController() throws FileNotFoundException {
    }

    @FXML
    public void initialize() {

        productGridPane.getChildren().clear();
        Label label1 = new Label(Product.APPLE.name());
        label1.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label1, 0, 0);
        Label label2 = new Label(Product.MILK.name());
        label2.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label2, 1, 0);
        Label label3 = new Label(Product.LETTUCE.name());
        label3.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label3, 2, 0);
        Label label4 = new Label(Product.JUICE.name());
        label4.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label4, 0, 1);
    }

    private VBox productView(Product product) throws FileNotFoundException {

        VBox layout = new VBox();
        layout.setAlignment(pos.CENTER);

        FileInputStream input = new FileInputStream("/Users/avindu/Desktop/shopping-cart/src/main/java/com/hellocode/shoppingcart/" + product.getImageFile());

        Image image = new Image(input);
        ImageView imageview = new ImageView(image);
        imageview.setFitWidth(100);
        imageView.setFitHeight(100);

        Label productName = new Label(product.name());
        Label price = new Label("Rs. " + product.getPrice());

        Button addButton = new Button("Add to cart");

        addButton.setUserData(product.name());
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //add product to shopping cart
            Node sourceComponent=(Node)actionEvent.getSource();

            String productName = (String)sourceComponent.getUserData();

            ShoppingCart shoppingcart=ShoppingCart.getInstance();

            shoppingcart.addProduct(productName);
            }
        });

        layout.getChildren().addAll(imageView, productName, price, addButton);

        return layout;
    }
}

