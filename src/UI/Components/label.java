package UI.Components;


import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

import static javafx.scene.layout.GridPane.setHgrow;


public class label extends Label {
    public Label font_size=null;

    public  Label dark_mode=null;

    HBox root_1 = new HBox();

    public label() {

        font_size = new Label();

        dark_mode=new Label();

        HBox SS = new HBox(dark_mode,font_size);

        font_size.setText("font size");
        dark_mode.setText("dark mode");


        font_size.setFont(new Font("Arial", 20));
        dark_mode.setFont(new Font("Arial", 20));


     root_1.getChildren().addAll(font_size,dark_mode);


        root_1.setMaxSize(100,50);
        setHgrow(dark_mode, Priority.ALWAYS);
        setHgrow(font_size, Priority.ALWAYS);


    }

}
