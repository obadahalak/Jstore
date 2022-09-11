package UI.Pages;

import java.io.FileNotFoundException;

import Modules.NAVBAR;
import Modules.Product;
import UI.Components.BlockView;
import UI.Components.NavBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import sample.INT;

public class Search {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        NavBar navbar = null ;

        Rectangle rec1 = null ;

        HBox field = null ;
            HBox jstore = null ;
                Label j = null ;
                Label store = null ;
            TextField search = null ;

        ScrollPane secondary_layout = null ;
            StackPane content = null ;
                Rectangle rec2 = null ;
                VBox momo = null ;
                    BlockView block = null ;
        INT i = null;
        public Search(INT i, Product[] RESULT) throws FileNotFoundException {
            this.i = i;
            navbar = new NavBar(i, NAVBAR.SEARCH);

                        //         Jstor        //

            j = new Label("J");
            j.setFont( new Font("Goudy stout",60) );
            j.setTextFill( Color.rgb(26,110,39) );
            j.setTranslateY(-10);
            store = new Label( "store" );
            store.setFont( new Font("Arial Rounded MT Bold",60) );
            store.setTextFill(Color.rgb(121,249,104));
            jstore = new HBox(j, store);
            jstore.setAlignment(Pos.TOP_RIGHT);
            jstore.setTranslateX(jstore.getTranslateX() - 10 );
            HBox.setHgrow(j, Priority.ALWAYS);
            HBox.setHgrow(store, Priority.ALWAYS);


                        //    search     //

            search = new TextField();
            search.setPromptText("what do you wont to search ? ");
            search.setBackground(new Background(new BackgroundFill(Color.rgb(165,230,138), CornerRadii.EMPTY, Insets.EMPTY)));
            search.setFont(new Font("Arial",25));
            search.setMaxWidth(400);
            search.setAlignment(Pos.TOP_LEFT);
            search.setTranslateY(20);
            search.setTranslateX(10);


                        //     field      //

            field = new HBox(search,jstore);
            field.setAlignment(Pos.TOP_CENTER);
            field.setSpacing(10);
            HBox.setHgrow(jstore,Priority.ALWAYS);
            HBox.setHgrow(search,Priority.ALWAYS);


                        //      secondary layout        //

            block = new BlockView("Search of your order : ",RESULT);
            block.setSpacing(10);
            momo = new VBox(block);
            VBox.setVgrow(block,Priority.ALWAYS);

            content = new StackPane();
            rec2 = new Rectangle();

            content.getChildren().addAll(rec2,momo);
            StackPane.setAlignment(momo,Pos.TOP_CENTER);
            StackPane.setMargin(momo,new Insets(0,40,0,40));

            secondary_layout = new ScrollPane(content);

            rec2.widthProperty().bind(secondary_layout.widthProperty());
            rec2.heightProperty().bind(secondary_layout.heightProperty());
            rec2.setFill(Color.WHITE);
            secondary_layout.setFitToWidth(true);
            secondary_layout.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            secondary_layout.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


                            //      primary layout      //

            primary_layout = new StackPane();

            rec1 = new Rectangle();
            rec1.widthProperty().bind(primary_layout.widthProperty());
            rec1.heightProperty().bind(primary_layout.heightProperty());
            rec1.setFill(Color.WHITE);

            primary_layout.getChildren().addAll(rec1,navbar,field,secondary_layout);
            StackPane.setAlignment(navbar,Pos.TOP_CENTER);
            StackPane.setAlignment(field,Pos.TOP_CENTER);
            StackPane.setAlignment(secondary_layout,Pos.TOP_CENTER);
            StackPane.setMargin(navbar,new Insets(0,0,0,0));
            StackPane.setMargin(field,new Insets(50,0,0,0));
            StackPane.setMargin(secondary_layout,new Insets(125,0,0,0));

            scene = new Scene(primary_layout,650,600,Color.WHITE);
        }
}