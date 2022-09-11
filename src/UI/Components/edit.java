package UI.Components;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.HBox;

public class edit extends HBox {

   public JFXTextField user_name=null;
    public   JFXTextField password =null;
    public  JFXTextField age =null;
    public  JFXTextField phone_number=null;
    public  JFXTextField location=null;

  public  edit()
    {
           user_name =new JFXTextField("user name");

        password =new JFXTextField("password");

        phone_number =new JFXTextField("phone_number");
        age =new JFXTextField("age");
        location =new JFXTextField("location");
        final String css = "-fx-border-width:0 0 1 0; -fx-border-color:red blue #2AC940 yellow;";
         setStyle(css);

getChildren().addAll(user_name,password,phone_number,age,location);





    }
}
