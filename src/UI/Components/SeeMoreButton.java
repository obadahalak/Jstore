package UI.Components;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SeeMoreButton extends Button {
    public SeeMoreButton(){
        super("see more");
        setBackground(new Background(new BackgroundFill(Color.rgb(42,201,64), CornerRadii.EMPTY, Insets.EMPTY)));
        setTextFill(Color.WHITE);
        setFont(new Font("Arial",18));

    }
}
