package UI.Components;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Item extends HBox {
    ImageView img = null;
    VBox details = null;
    HBox name_price = null;
    Label description = null;
    Label name = null;
    Label price = null;
    HBox icons = null;
    Button add_to_wishlist = null;
    Button add_to_cart = null;
    public Item(String name,String price , String description , String img,boolean isIN_WISHLIST,boolean isIN_CART) throws FileNotFoundException {

        this.name = new Label(name);
        this.price = new Label(price);
        name_price = new HBox(this.name,this.price);
        HBox.setHgrow(this.name,Priority.ALWAYS);
        HBox.setHgrow(this.price,Priority.ALWAYS);
        this.price.setAlignment(Pos.BOTTOM_LEFT);
        this.name.setFont(new Font("Arial",20));
        this.name.setStyle("-fx-font-weight: bold;");
        this.price.setFont(new Font("Arial",12));
        this.price.setTextFill(Color.rgb(96,153,104,0.42));
        name_price.setSpacing(4);


        this.description = new Label(description);
        this.description.setFont(new Font("Arial",14));
        this.description.setWrapText(true);



        add_to_wishlist =  (Button)GlyphsDude.createIconButton(FontAwesomeIcon.HEART,"","20","18", ContentDisplay.LEFT);
        add_to_wishlist.getStyleClass().add( isIN_WISHLIST  ? "wishlist-icon" : "not-wishlist-icon");
        add_to_cart =  GlyphsDude.createIconButton(FontAwesomeIcon.SHOPPING_CART,"","20","18", ContentDisplay.LEFT);
        add_to_cart.getStyleClass().add("cart-icon");
         icons = new HBox(add_to_cart,add_to_wishlist);
        HBox.setHgrow(add_to_cart,Priority.ALWAYS);
        HBox.setHgrow(add_to_wishlist,Priority.ALWAYS);
        icons.setAlignment(Pos.BOTTOM_RIGHT);
        icons.setSpacing(20);
        add_to_cart.setMinSize(10,10);
        add_to_cart.setMaxSize(10,10);
        add_to_wishlist.setMinSize(10,10);
        add_to_wishlist.setMaxSize(10,10);


        details = new VBox(name_price,this.description,icons);
        VBox.setVgrow(name_price,Priority.ALWAYS);
        VBox.setVgrow(this.description,Priority.ALWAYS);
        VBox.setVgrow(icons,Priority.ALWAYS);
        details.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(icons,new Insets(0,20,10,0));

        this.img = new ImageView(new Image(img));
        this.img.setFitHeight(200);
        this.img.setFitWidth(200);

        getChildren().addAll(this.img,details);
        setHgrow(this.img,Priority.ALWAYS);
        setHgrow(details,Priority.ALWAYS);
        setAlignment(Pos.CENTER);
        setMaxWidth(Double.MAX_VALUE);
        setMinWidth(400);
        setBackground(new Background(new BackgroundFill(Color.rgb(192,192,192),CornerRadii.EMPTY, Insets.EMPTY)));
        setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");
        add_to_wishlist.setOnAction(e->{

        });
    }

}
