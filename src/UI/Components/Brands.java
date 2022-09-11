package UI.Components;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Brands extends ScrollPane {
    int pos = 0;
    final int minPos = 0;
    final int maxPos = 1000;
    HBox content;
    MyButton[] brands = new MyButton[BrandsEnum.values().length];
    public Brands(){
        for(int i = 0 ; i < BrandsEnum.values().length ; i++) {
            brands[i] = new MyButton(BrandsEnum.values()[i].name,20.0);
            brands[i].setAlignment(Pos.CENTER);
        }
        content = new HBox();


        content.getChildren().addAll(brands);
        setContent(content);
     //   setStyle("-fx-background-color: transparent;");
        setFitToHeight(true);
        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        content.setAlignment(Pos.CENTER);

        setMaxHeight(50);
        setOnScroll(event -> {
            if(event.getDeltaX() == 0 && event.getDeltaY() != 0) {
                setHvalue(getHvalue() - event.getDeltaY() / content.getWidth());
            }
        });

    }

}
