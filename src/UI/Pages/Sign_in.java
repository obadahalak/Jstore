package UI.Pages;

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

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Sign_in {
    public static Scene scene;

    StackPane primary_layout = null ;
    HBox Jstore = null ;
    Label j = null ;
    Label store = null ;
    StackPane content = null ;
    TextField userName = null ;
    PasswordField passWord = null ;
    Button sign_in = null;
    Rectangle rec2 = null ;
    Button Help = null;
    Button Home = null ;
    Rectangle rec = null ;
    VBox main = null;


    public Sign_in (INT i){

        j = new Label("J");
        j.setFont( new Font("Goudy stout",60) );
        j.setTextFill( Color.rgb(26,110,39) );
        j.setTranslateY(-10);
        store = new Label( "store" );
        store.setFont( new Font("Arial Rounded MT Bold",60) );
        store.setTextFill(Color.rgb(121,249,104));
        Jstore = new HBox(j, store);
        HBox.setHgrow(Jstore,Priority.ALWAYS);


        userName = new TextField();
        userName.setPromptText("User Name");
        userName.setFont(new Font("Arial Rounded MT Bold",25));
        userName.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
        userName.setMaxWidth(200);
        userName.setMaxHeight(40);
        passWord = new PasswordField();
        passWord.setPromptText("Password");
        passWord.setFont(new Font("Arial Rounded MT Bold",25));
        passWord.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
        passWord.setMaxWidth(200);
        passWord.setMaxHeight(40);
        sign_in = new Button("Sign in");
        sign_in.setFont(new Font("Arial Rounded MT Bold",25));
        sign_in.setTextFill(Color.WHITE);
        sign_in.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
        sign_in.setMaxWidth(200);
        sign_in.setMaxHeight(40);
        main = new VBox(userName,passWord,sign_in);
        main.setSpacing(20);
        userName.setAlignment(Pos.TOP_CENTER);
        passWord.setAlignment(Pos.CENTER);
        sign_in.setAlignment(Pos.BOTTOM_CENTER);
        rec2 = new Rectangle();
        content = new StackPane(rec2,main);
        content.setMaxWidth(400);
        content.setMaxHeight(250);
        main.setAlignment(Pos.CENTER);
        rec2.widthProperty().bind(content.widthProperty());
        rec2.heightProperty().bind(content.heightProperty());
        rec2.setFill(Color.rgb(121,249,104));

        Home = (Button) GlyphsDude.createIconButton(FontAwesomeIcon.HOME,"","20","18", ContentDisplay.LEFT);
        Home.getStyleClass().add("Home-icon");

        Help = (Button) GlyphsDude.createIconButton(FontAwesomeIcon.QUESTION_CIRCLE,"","20","18", ContentDisplay.LEFT);
        Help.getStyleClass().add("Help-icon");

        rec = new Rectangle();
        primary_layout = new StackPane();
        primary_layout.getChildren().addAll(rec,Home,Jstore,content,Help);
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());
        rec.setFill(Color.WHITE);
        StackPane.setAlignment(Home,Pos.TOP_LEFT);
        StackPane.setMargin(Home,new Insets(10,0,0,10));
        Jstore.setAlignment(Pos.TOP_CENTER);
        StackPane.setMargin(Jstore,new Insets(100,0,0,0));
        StackPane.setAlignment(Help,Pos.BOTTOM_RIGHT);
        StackPane.setMargin(Help,new Insets(0,15,15,0));

        scene = new Scene(primary_layout,650,600,Color.WHITE);
        scene.getStylesheets().add(getClass().getResource("/sheets/style.css").toExternalForm());

        sign_in.setOnAction(e->{
            Users user = null;
            try {
                user =  Main.db_controller.checkUser(userName.getText(), passWord.getText());
                if (user != null) {
                    Main.UID = user.getID();
                    i.createProfileUI(user);
                }else{
                    rec2.setFill(Color.rgb(255,0,0));
                }
            } catch (SQLException | FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    }


}

