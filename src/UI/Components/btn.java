package UI.Components;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class btn extends HBox {

    public JFXButton edit = null;
    public   JFXButton logout = null;
    public   JFXButton logout2 = null;

    public btn() {


            edit = new JFXButton();

            logout = new JFXButton();

            edit.setText("edit");

            logout.setText("logout");
            edit = new JFXButton("edit");
            logout = new JFXButton("logout");

            getChildren().addAll(edit, logout);

            edit.setStyle("-fx-border-width:0 0 1 0; -fx-background-color:#16d32d;-fx-background-radius: 6,1,1;");

            logout.setStyle("-fx-border-width:0 0 1 0; -fx-background-color:#16d32d;-fx-background-radius: 6,1,1;");

            setHgrow(edit, Priority.ALWAYS);
            setHgrow(logout, Priority.ALWAYS);
            setMaxHeight(50);
            setMaxWidth(50);
        }

    }
