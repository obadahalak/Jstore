package UI.Components;
import UI.Pages.settings;
import sample.INT;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import sample.INT;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public  class mode extends HBox {
public    HBox root = new HBox();

    public mode() throws FileNotFoundException, SQLException, ClassNotFoundException {


        root.setPadding(new Insets(10));
        root.setSpacing(5);

        ToggleGroup group = new ToggleGroup();


        ToggleButton dark = new ToggleButton("ON");

        ToggleButton white = new ToggleButton("OFF");

        dark.setOnAction(e -> {

            dark.setStyle("-fx-background-color: green;");

        dark.toFront();
        });

        white.setOnAction(e -> {

            white.setStyle("-fx-background-color: grey;");

            white.toFront();
        });


        dark.setToggleGroup(group);
        white.setToggleGroup(group);



       root.getChildren().addAll(dark, white);

    }
}
