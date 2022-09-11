package UI.Pages;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import sample.INT;

public class FirstUI {
        public Scene scene;
        INT i;

        StackPane primary_layout = null ;
            HBox jstore = null ;
                 Label j = null ;
                 Label store = null ;
            StackPane content = null ;
                 Button in = null ;
                 Button up = null ;
                 Rectangle rec2 = null ;
            HBox soso = null ;
                Button home = null ;
            Rectangle rec = null ;


        public FirstUI (INT i){
            this.i = i;
            j = new Label("J");
            j.setFont( new Font("Goudy stout",60) );
            j.setTextFill( Color.rgb(26,110,39) );
            j.setTranslateY(-10);

            store = new Label( "store" );
            store.setFont( new Font("Arial Rounded MT Bold",60) );
            store.setTextFill(Color.rgb(121,249,104));

            jstore = new HBox(j, store);
            jstore.setAlignment(Pos.TOP_CENTER);
            HBox.setHgrow(jstore,Priority.ALWAYS);


            in = new Button("Sing in");
            in.setFont(new Font("Arial Rounded MT Bold",50));
            in.setTextFill(Color.WHITE);
            in.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
            in.setMaxWidth(250);
            in.setMaxHeight(20);

            up = new Button("Sing up");
            up.setFont(new Font("Arial Rounded MT Bold",50));
            up.setTextFill(Color.WHITE);
            up.setBackground(new Background(new BackgroundFill(Color.rgb(96,177,83), CornerRadii.EMPTY, Insets.EMPTY)));
            up.setMaxWidth(250);
            up.setMaxHeight(10);

            rec2 = new Rectangle();

            content = new StackPane(rec2,in,up);
            content.setAlignment(Pos.CENTER);
            content.setMaxWidth(450);
            content.setMaxHeight(350);
            StackPane.setMargin(in,new Insets(-100,0,0,0));
            StackPane.setMargin(up,new Insets(100,0,0,0));

            rec2.widthProperty().bind(content.widthProperty());
            rec2.heightProperty().bind(content.heightProperty());
            rec2.setFill(Color.rgb(121,249,104));

            primary_layout = new StackPane();
            primary_layout.getChildren().addAll(content,jstore);
            StackPane.setMargin(jstore,new Insets(50,0,0,0));

            rec = new Rectangle();
            rec.widthProperty().bind(primary_layout.widthProperty());
            rec.heightProperty().bind(primary_layout.heightProperty());
            rec.setFill(Color.WHITE);




            home = new Button("HOME",GlyphsDude.createIconButton(FontAwesomeIcon.HOME,"","20","18", ContentDisplay.LEFT));
            home.setContentDisplay(ContentDisplay.LEFT);










            soso = new HBox();

            scene = new Scene(primary_layout,650,600,Color.WHITE);
        }


}
