package UI.Components;

import Modules.Product;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;

public class BlockView extends VBox {
    String text = "Stay cool and fresh in the Nike Sportswear Essential Crop    Top. This breezy, loose-fitting crop top features soft jersey cotton fabric for a comfortable fit. ";
    SeeMoreButton see_more = null;
    Item[] items = null;
    GridPane items_viewer = null;
    Label title = null;
    int i = 4;
    public BlockView(String title, Product[] POPULAR_ITEMS) throws FileNotFoundException {

        see_more = new SeeMoreButton();
        this.title = new Label(title);
        items = new Item[POPULAR_ITEMS.length];
        items_viewer = new GridPane();
        System.out.println(POPULAR_ITEMS.length);
       if (POPULAR_ITEMS.length > 3){
           for(int i = 0 ; i < 4 ; i=i+2)
           {

               items[i] = new Item(POPULAR_ITEMS[i].getTITLE(),POPULAR_ITEMS[i].getPRICE(),POPULAR_ITEMS[i].getDESCRIPE(),POPULAR_ITEMS[i].getIMG(),POPULAR_ITEMS[i].isIN_WISHLISIT(),false);
               items[i+1] = new Item(POPULAR_ITEMS[i+1].getTITLE(),POPULAR_ITEMS[i+1].getPRICE(),POPULAR_ITEMS[i+1].getDESCRIPE(),POPULAR_ITEMS[i+1].getIMG(),POPULAR_ITEMS[i+1].isIN_WISHLISIT(),false);
               items_viewer.add(items[i],0,i);
               items_viewer.add(items[i+1],1,i);

               GridPane.setHgrow(items[i], Priority.ALWAYS);
               GridPane.setHgrow(items[i+1], Priority.ALWAYS);

           }
       }
        items_viewer.setHgap(10);
        items_viewer.setVgap(10);

        getChildren().addAll(this.title,items_viewer,see_more);

        this.title.setAlignment(Pos.BOTTOM_LEFT);
        this.title.setStyle("-fx-font-weight: bold;");
        this.title.setFont(new Font(28));

        see_more.setAlignment(Pos.BOTTOM_LEFT);

        setSpacing(8);



        see_more.setOnAction(e -> {
            int j = i;
            for(i = j ; i < j + 3 ; i=i+2) {
                System.out.println(i);

                try {
                    items[i] = new Item(POPULAR_ITEMS[i].getTITLE(), POPULAR_ITEMS[i].getPRICE(), POPULAR_ITEMS[i].getDESCRIPE(), POPULAR_ITEMS[i].getIMG(), POPULAR_ITEMS[i].isIN_WISHLISIT(), false);
                    items[i + 1] = new Item(POPULAR_ITEMS[i + 1].getTITLE(), POPULAR_ITEMS[i + 1].getPRICE(), POPULAR_ITEMS[i + 1].getDESCRIPE(), POPULAR_ITEMS[i + 1].getIMG(), POPULAR_ITEMS[i + 1].isIN_WISHLISIT(), false);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                items_viewer.add(items[i], 0, i);
                items_viewer.add(items[i + 1], 1, i);

                GridPane.setHgrow(items[i], Priority.ALWAYS);
                GridPane.setHgrow(items[i + 1], Priority.ALWAYS);
            }
            });
    }


}
