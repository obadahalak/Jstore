package UI.Pages;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import sample.INT;

public class StartPage {
    public static Scene scene;

    StackPane primary_layout = null ;
    HBox Jstore = null ;
    Label j = null ;
    Label store = null ;
    StackPane content = null ;
    Button sign_in = null ;
    Button sign_up = null ;
    Rectangle rec2 = null ;
    Button Help = null;
    Button Home = null ;
    Rectangle rec = null ;


    public StartPage (INT i){

        j = new Label("J");
        j.setFont( new Font("Goudy stout",60) );
        j.setTextFill( Color.rgb(26,110,39) );
        j.setTranslateY(-10);
        store = new Label( "store" );
        store.setFont( new Font("Arial Rounded MT Bold",60) );
        store.setTextFill(Color.rgb(121,249,104));
        Jstore = new HBox(j, store);
        HBox.setHgrow(Jstore,Priority.ALWAYS);


        sign_in = new Button("Sign in");
        sign_in.setFont(new Font("Arial Rounded MT Bold",30));
        sign_in.setTextFill(Color.WHITE);
        sign_in.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
        sign_in.setMaxWidth(200);
        sign_in.setMaxHeight(30);
        sign_up = new Button("Sign up");
        sign_up.setFont(new Font("Arial Rounded MT Bold",30));
        sign_up.setTextFill(Color.WHITE);
        sign_up.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
        sign_up.setMaxWidth(200);
        sign_up.setMaxHeight(30);
        rec2 = new Rectangle();
        content = new StackPane(rec2,sign_in,sign_up);
        content.setAlignment(Pos.CENTER);
        content.setMaxWidth(350);
        content.setMaxHeight(200);
        StackPane.setMargin(sign_in,new Insets(-75,0,0,0));
        StackPane.setMargin(sign_up,new Insets(75,0,0,0));
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
            i.createSignInUI();
        });
        sign_up.setOnAction(e->{
            i.createSignUpUI();
        });
    }


}
