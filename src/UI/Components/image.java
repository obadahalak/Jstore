package UI.Components;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;

public class image extends HBox {
    public  Circle cir = null;
//Image image=null;
public   ImageView img = null;

    public image(String img) throws FileNotFoundException {




        cir = new Circle(100, 50, 80);
        cir.setStroke(Color.ALICEBLUE);
        cir.setFill(Color.AQUA);

        cir.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

       cir.setFill(new ImagePattern(new Image(("http://localhost:8080/img/item.png"))));


    }


}

