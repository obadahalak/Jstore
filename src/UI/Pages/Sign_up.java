package UI.Pages;
import UI.Pages.Sign_up;
import Modules.Users;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import sample.INT;
import sample.Main;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Sign_up {
    public static Scene scene;
    Button signup = null;


    StackPane primary_layout = null ;
    HBox Jstore = null ;
    Label j = null ;
    Label store = null ;
    StackPane content = null ;
    TextField fullName = null ;
    PasswordField passWord = null ;
    TextField phoneNumber = null;
    TextField location = null;
    TextField age = null;
    Button submit = null;
    Rectangle rec2 = null ;
    Button Help = null;
    Button Home = null ;
    Rectangle rec = null ;
    VBox main = null;
   // VBox root = null;


    public Sign_up (INT i) {

        j = new Label("J");
        j.setFont(new Font("Goudy stout", 60));
        j.setTextFill(Color.rgb(26, 110, 39));
        j.setTranslateY(-10);
        store = new Label("store");
        store.setFont(new Font("Arial Rounded MT Bold", 60));
        store.setTextFill(Color.rgb(121, 249, 104));
        Jstore = new HBox(j, store);
        HBox.setHgrow(Jstore, Priority.ALWAYS);


        fullName = new TextField();
        fullName.setPromptText("Full Name");
        fullName.setFont(new Font("Arial Rounded MT Bold", 20));
        fullName.setBackground(new Background(new BackgroundFill(Color.rgb(96, 177, 83), CornerRadii.EMPTY, Insets.EMPTY)));
        fullName.setMaxWidth(200);
        fullName.setMaxHeight(30);
        phoneNumber = new TextField();
        phoneNumber.setPromptText("Phone Number");
        phoneNumber.setFont(new Font("Arial Rounded MT Bold", 20));
        phoneNumber.setBackground(new Background(new BackgroundFill(Color.rgb(96, 177, 83), CornerRadii.EMPTY, Insets.EMPTY)));
        phoneNumber.setMaxWidth(200);
        phoneNumber.setMaxHeight(30);
        age = new TextField();
        age.setPromptText("Age");
        age.setFont(new Font("Arial Rounded MT Bold", 20));
        age.setBackground(new Background(new BackgroundFill(Color.rgb(96, 177, 83), CornerRadii.EMPTY, Insets.EMPTY)));
        age.setMaxWidth(200);
        age.setMaxHeight(30);
        location = new TextField();
        location.setPromptText("User Name");
        location.setFont(new Font("Arial Rounded MT Bold", 20));
        location.setBackground(new Background(new BackgroundFill(Color.rgb(96, 177, 83), CornerRadii.EMPTY, Insets.EMPTY)));
        location.setMaxWidth(200);
        location.setMaxHeight(30);
        passWord = new PasswordField();
        passWord.setPromptText("Password");
        passWord.setFont(new Font("Arial Rounded MT Bold", 20));
        passWord.setBackground(new Background(new BackgroundFill(Color.rgb(96, 177, 83), CornerRadii.EMPTY, Insets.EMPTY)));
        passWord.setMaxWidth(200);
        passWord.setMaxHeight(30);
        submit = new Button("Submit");
        submit.setFont(new Font("Arial Rounded MT Bold", 20));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(96, 177, 83), CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setMaxWidth(150);
        submit.setMaxHeight(30);
        main = new VBox(fullName, phoneNumber, location, age, passWord, submit);
        main.setSpacing(15);
        rec2 = new Rectangle();
        content = new StackPane(rec2, main);
        content.setMaxWidth(400);
        content.setMaxHeight(350);
        main.setAlignment(Pos.CENTER);
        rec2.widthProperty().bind(content.widthProperty());
        rec2.heightProperty().bind(content.heightProperty());
        rec2.setFill(Color.rgb(121, 249, 104));

        Home = (Button) GlyphsDude.createIconButton(FontAwesomeIcon.HOME, "", "20", "18", ContentDisplay.LEFT);
        Home.getStyleClass().add("Home-icon");

        Help = (Button) GlyphsDude.createIconButton(FontAwesomeIcon.QUESTION_CIRCLE, "", "20", "18", ContentDisplay.LEFT);
        Help.getStyleClass().add("Help-icon");

       /* root = new VBox(Jstore,content);
        root.setSpacing(20);
        Jstore.setAlignment(Pos.TOP_CENTER);
        content.setAlignment(Pos.CENTER);*/

        rec = new Rectangle();
        primary_layout = new StackPane();
        primary_layout.getChildren().addAll(rec, Home, Jstore, content, Help);
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());
        rec.setFill(Color.WHITE);
        StackPane.setMargin(content, new Insets(100, 0, 0, 0));
        StackPane.setAlignment(Home, Pos.TOP_LEFT);
        StackPane.setMargin(Home, new Insets(10, 0, 0, 10));
        Jstore.setAlignment(Pos.TOP_CENTER);
        StackPane.setMargin(Jstore, new Insets(75, 0, 0, 0));
        StackPane.setAlignment(Help, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(Help, new Insets(0, 15, 15, 0));

        scene = new Scene(primary_layout, 650, 600, Color.WHITE);

        scene.getStylesheets().add(getClass().getResource("/sheets/style.css").toExternalForm());

        submit.setOnAction(e->{
            Users user = null;
            try {
                user =  Main.db_controller.create_user(fullName.getText(),passWord.getText(),age.getText(),location.getText(),phoneNumber.getText());
                if (fullName == null&&phoneNumber ==null &&passWord==null&& age==null&&location==null) {
                    rec2.setFill(Color.rgb(255,0,0));
                    JOptionPane.showMessageDialog(null,"please enter your information ^_^");

                }else{
                    i.createProfileUI(user);
                    JOptionPane.showMessageDialog(null,"user inserted");


                }

            } catch (SQLException | FileNotFoundException ex) {
            ex.printStackTrace();
            }
        });





    }
}

