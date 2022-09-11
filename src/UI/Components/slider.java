package UI.Components;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class slider extends Slider {

    slider  sdr=null;
    public slider()

    {
        Stage stage1=new Stage();
        Group root = new Group();
        Scene scene = new Scene(root);

      stage1.setScene(scene);



        final Slider slider = new Slider();


        final ProgressBar pb = new ProgressBar(0);


        final ProgressIndicator pi = new ProgressIndicator(0);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                pb.setProgress(new_val.doubleValue() / 50);
                pi.setProgress(new_val.doubleValue() / 50);
            }
        });

        StackPane pane = new StackPane();
       pane.getChildren().addAll(pb, slider);

        final HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(pane, pi);
        scene.setRoot(hb);
       getChildren().addAll(slider);

    }
}
