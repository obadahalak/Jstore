package UI.Pages;

import Modules.NAVBAR;
import Modules.Product;
import UI.Components.BlockView;
import UI.Components.Brands;
import UI.Components.NavBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.INT;

import java.io.FileNotFoundException;

public class Products  {
    public Scene scene = null;
        StackPane primary_layout = null;
        ScrollPane secondary_layout = null;
        StackPane content = null;
        VBox blocks = null;
        NavBar navbar = null;
        Brands brands  = null;
        BlockView popular = null;
        BlockView best_sells = null;
        Rectangle rec = new Rectangle();
        INT i = null;
         public Products(Product[] POPULAR_ITEMS,INT i) throws FileNotFoundException {
            this.i = i;
             navbar = new NavBar(i, NAVBAR.PRODUCT);
            brands = new Brands();
            popular = new BlockView("POPULAR",POPULAR_ITEMS);
            best_sells = new BlockView("BEST SELLS",POPULAR_ITEMS);
             blocks = new VBox(popular,best_sells);
             content = new StackPane();
             rec.widthProperty().bind(content.widthProperty());
             rec.heightProperty().bind(content.heightProperty());
             rec.setFill(Color.WHITE);
             content.getChildren().addAll(rec,blocks);
             secondary_layout = new ScrollPane(content);
             primary_layout = new StackPane(navbar,brands,secondary_layout);
            StackPane.setAlignment(navbar, Pos.TOP_CENTER);
            StackPane.setAlignment(brands,Pos.TOP_CENTER);
            StackPane.setAlignment(secondary_layout,Pos.CENTER);
            secondary_layout.setFitToWidth(true);
            secondary_layout.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            StackPane.setAlignment(blocks,Pos.CENTER);
            StackPane.setMargin(blocks,new Insets(0,40,0,40));

            StackPane.setMargin(brands,new Insets(50,0,0,0));
            StackPane.setMargin(secondary_layout,new Insets(100,0,0,0));
            scene = new Scene(primary_layout,650,600);
            scene.getStylesheets().add(getClass().getResource("/sheets/style.css").toExternalForm());


         }

}
