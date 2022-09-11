package UI.Pages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Splash {
   public Scene scene = null;
   StackPane primary = null;
   Rectangle rec = null;
   ImageView loader = null;

    public Splash() {
        rec = new Rectangle(600,600, Color.rgb(42,201,64));
        loader = new ImageView(new Image("http://127.0.0.1:8080/img/loader.gif"));
        primary = new StackPane(rec,loader);
        StackPane.setAlignment(loader, Pos.CENTER);
        loader.setFitWidth(60);
        loader.setFitHeight(60);
        scene = new Scene(primary);
    }
}
