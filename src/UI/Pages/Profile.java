package UI.Pages;

import Modules.NAVBAR;
import Modules.Product;
import Modules.Users;
import UI.Components.BlockView;
import UI.Components.NavBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import sample.INT;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Profile {
    public static Scene scene;

    StackPane primary_layout = null;
        NavBar navbar = null ;
        Rectangle rec = null ;
        VBox secondary_layout = null;
              HBox personal = null ;
                   ImageView img = null ;
                   VBox details = null ;
                         Label name = null ; ;
                         Label phone = null ;
                         Label age = null ;
                         Label loc = null ;

              ScrollPane history = null ;
                    StackPane stack = null ;
                        Rectangle rec2 = null ;
                        BlockView hist = null ;
            INT i = null;
    public Profile(INT i, Users user, Product[] HISTORY) throws FileNotFoundException {
        this.i = i;

        navbar = new NavBar(i, NAVBAR.PROFILE);

        this.name = new Label("User name : "  + user.getFullname() ) ;
        this.phone = new Label("Phone number : " + user.getPhoneNumber() ) ;
        this.age = new Label("Age : " + user.getAge() ) ;
        this.loc = new Label("Location : " + user.getLocation() ) ;
        this.name.setTextFill(Color.GREEN);
        this.phone.setTextFill(Color.GREEN);
        this.age.setTextFill(Color.GREEN);
        this.loc.setTextFill(Color.GREEN);
        this.name.setFont(new Font("Arial",36));
        this.phone.setFont(new Font("Arial",24));
        this.age.setFont(new Font("Arial",24));
        this.loc.setFont(new Font("Arial",24));

        details = new VBox(this.name,this.phone,this.age,this.loc);
        VBox.setVgrow(this.name, Priority.ALWAYS);
        VBox.setVgrow(this.phone, Priority.ALWAYS);
        VBox.setVgrow(this.age, Priority.ALWAYS);
        VBox.setVgrow(this.loc, Priority.ALWAYS);
        details.setSpacing(5);

        Circle cir = new Circle(250,200,80);
        cir.setStroke(Color.SEAGREEN);
        cir.setFill(Color.SNOW);
        cir.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        cir.setFill(new ImagePattern(new Image("http://127.0.0.1:8080//img//item.png")));

        personal = new HBox(cir,details);

        HBox.setHgrow(cir,Priority.ALWAYS);
        HBox.setHgrow(details,Priority.ALWAYS);
        HBox.setMargin(details,new Insets(10,0,0,10));
        HBox.setMargin(cir,new Insets(10,0,10,0));

        stack = new StackPane();

        rec2 = new Rectangle();
        rec2.widthProperty().bind(stack.widthProperty());
        rec2.heightProperty().bind(stack.heightProperty());
        rec2.setFill(Color.WHITE);

        hist = new BlockView("History",HISTORY);

        stack.getChildren().addAll(rec2,hist);

        history = new ScrollPane(stack);
        history.setFitToWidth(true);
        history.setFitToHeight(true);
        history.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        history.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        secondary_layout = new VBox(personal,history);

        VBox.setMargin(personal,new Insets(50,0,0,0));
        VBox.setMargin(history,new Insets(0,40,0,40));
        VBox.setVgrow(history,Priority.ALWAYS);

        primary_layout = new StackPane();

        rec = new Rectangle();
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());
        rec.setFill(Color.WHITE);

        primary_layout.getChildren().addAll(rec, secondary_layout, navbar);

        StackPane.setAlignment(navbar, Pos.TOP_CENTER);
        StackPane.setAlignment(history, Pos.CENTER);

        
        scene = new Scene(primary_layout,650,600,Color.WHITE);
    }
}