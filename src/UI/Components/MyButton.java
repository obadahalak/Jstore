package UI.Components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class MyButton extends Button {
    public MyButton(String value ){
        super(value);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setFont(new Font("Arial",20));
        setTextFill(Color.BLACK);
        setPrefHeight(50);

        setMinWidth(Double.MIN_VALUE);
        setMaxWidth(Double.MAX_VALUE);
    }
    public MyButton(String value , Double font_size)
    {
         super(value);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setFont(new Font("Arial",font_size));
        setTextFill(Color.BLACK);
        setPrefHeight(50);
        setPrefWidth(200);

        setMinWidth(Double.MIN_VALUE);
        setMaxWidth(Double.MAX_VALUE);

    }
    protected void setColor(){
        setTextFill(Color.rgb(42,201,64));
    }
}
