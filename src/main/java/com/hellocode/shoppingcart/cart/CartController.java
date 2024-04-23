package com.hellocode.shoppingcart.cart;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.classfile.Label;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class CartController {

    @FXML

    private VBox cartPane;

    private

    @FXML
    public void initialize(){
        //view populate
        List<CartEntry> entries=ShoppingCart.getInstance().getEntries();

        cartPane.getChildren().clear();

        if(entries.isEmpty()){

            Label emptyLabel=new Label("Empty Cart");
            cartPane.getChildren().add(emptyLabel);
        }else{

            Label shoppingCartTitle=new Label("Shopping cart");

            cartPane.getChildren().add(shoppingCartTitle);

            for(CartEntry cartEntry:entries){

                HBox productview=cartEntryView(cartEntry);

                Label productName = new Label(cartEntry.getProduct().name());
                hbox.getChildren().add(productName);

                cartPane.getChildren().add(productview);


            }
            Separator separator=new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(seperator);

            HBox totalView=totalView(ShoppingCart.getInstance().calculateTotal());
            cartPane.getChildren().add(totalView);





        }
    }
    private HBox totalView(float totalPrice){

        HBox layout=new HBox();
        layout.setAlignment(Pos.CENTER);

        Label totalLabel=new Label("Total : ");
        totalLabel.setStyle("-fx-font-size:15pt;");

        this.totalPriceLabel=new Label(String.valueOf(totalPrice));

        layout.getChildren().addAll(totalLabel, this.totalPriceLabel);
        return layout;
    }
    private HBox cartEntryView(CartEntry cartentry) throws FileNotFoundException{

        HBox layout=new HBox();

        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input=new FileInputStream("/Users/avindu/Desktop/shopping-cart/src/main/java/com/hellocode/shoppingcart/cart"+ cartentry.getProduct().getImageFile());

        Image image=new Image(input);

        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        Label productName=new Label(cartentry.getProduct().name());

        productName.setPrewidth(100);
        productName.setStyle("-fx-font-size:15pt; -fx-padding:5px");

        int quantity;
        quantity.setStyle("-fx-padding:5px");

        Button plusButton=new Button("+");
        plusButton.setStyle("-fx-padding:5px");
        plusButton.setUserData(cartentry.getProduct().name());
        plusButton.setOnAction(e ->{
            String name=(String) ((Node).getSource()).getUserData();
            ShoppingCart.getInstance().addProduct(name);
            quantity.setText(ShoppingCart.getInstance().getQuantity(name));

            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getInstance().calculateTotal());

        });


        Button minusButton=new Button("-");
        plusButton.setStyle("-fx-padding:5px");

        Label price=new Label(String.valueOf("Rs."+cartentry.getProduct().getPrice()));
        price.setStyle("-fx-padding:5px");


        layout.getChildren().addAll(imageView, productName, plusButton, quantity, minusButton,price);

        return layout;
    }
}
