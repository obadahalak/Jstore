package UI.Pages;
import Modules.NAVBAR;
import UI.Components.*;
import UI.Components.mode;
import java.sql.*;
import UI.Components.NavBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import sample.INT;

import UI.Components.label;
import UI.Components.slider;
import com.jfoenix.controls.JFXButton;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import javax.print.attribute.standard.MediaSize;
import java.io.FileNotFoundException;


public class settings extends HBox {
    public  static  Scene scene ;
    ScrollPane secondary_layout = null ;

    //public DBController D=new DBController((INT) this);
    NavBar navBar=null;
    slider sdr = null;

    StackPane primary_layout = null ;

    StackPane content = null;

    JFXButton edit = null;

    JFXButton logout = null;

    label ssss = new label();

    mode md=new mode();

    Rectangle rec = new Rectangle();


    public settings(INT i) throws FileNotFoundException, SQLException, ClassNotFoundException {



        navBar = new NavBar(i, NAVBAR.SETTING);

        double sliderWidth = 200;

        final Slider slider = new Slider();

        primary_layout = new StackPane();

        edit = new JFXButton();

        logout = new JFXButton();

        edit dd = new edit();

        btn bb = new btn();

        image ss = new image("http://localhost:8080/img/item.png");


        sdr = new slider();


        content = new StackPane();

        secondary_layout = new ScrollPane(content);

        bb.logout.setMaxSize(100, 30);

        bb.edit.setMaxSize(100, 30);

        dd.user_name.setMaxSize(150, 10);

        dd.password.setMaxSize(150, 10);

        dd.phone_number.setMaxSize(150, 10);

        dd.age.setMaxSize(150, 10);

        dd.location.setMaxSize(150, 10);

        sdr.setMaxSize(100, 50);

        setHgrow( ssss.dark_mode, Priority.ALWAYS);
        setHgrow( ssss.font_size, Priority.ALWAYS);

       ssss.dark_mode.setMaxSize(100,50);

        ssss.font_size.setMaxSize(100,50);


        setHgrow(edit, Priority.ALWAYS);
        primary_layout.getChildren().addAll(
                navBar,
                ss.cir,
                md.root,
                dd.user_name,
                dd.password,
                dd.location,
                dd.phone_number,
                dd.age,
                bb.edit,
                bb.logout,
                sdr, ssss.font_size, ssss.dark_mode);
        StackPane.setAlignment(navBar,Pos.TOP_CENTER);
     //   StackPane.setAlignment(secondary_layout,Pos.TOP_CENTER);

        StackPane.setAlignment(ssss.font_size, Pos.TOP_CENTER);
        StackPane.setAlignment(md.root, Pos.TOP_CENTER);


        StackPane.setAlignment(sdr, Pos.TOP_CENTER);

        StackPane.setAlignment(ss.cir, Pos.TOP_LEFT);

        StackPane.setAlignment(dd.user_name, Pos.CENTER_LEFT);

        StackPane.setAlignment(dd.location, Pos.CENTER_LEFT);

        StackPane.setAlignment(dd.password, Pos.CENTER_LEFT);

        StackPane.setAlignment(dd.phone_number, Pos.CENTER_LEFT);

        StackPane.setAlignment(dd.age, Pos.CENTER_LEFT);

        StackPane.setAlignment(bb.edit, Pos.BOTTOM_LEFT);

        StackPane.setAlignment(bb.logout, Pos.BOTTOM_RIGHT);

        StackPane.setAlignment(ssss.font_size, Pos.TOP_CENTER);

        StackPane.setAlignment(ssss.dark_mode, Pos.TOP_CENTER);


//   StackPane.setMargin(secondary_layout,new Insets(125,0,0,0));

        StackPane.setMargin(ss.cir, new Insets(60, 100, 400, 10));

        StackPane.setMargin(navBar,new Insets(0,0,0,0));

        StackPane.setMargin(sdr, new Insets(120, 0, 160, 200));

        StackPane.setMargin(md.root, new Insets(180, 0, 260, 370));

        StackPane.setMargin(dd.user_name, new Insets(100, 400, 200, 20));

        StackPane.setMargin(dd.password, new Insets(200, 400, 200, 20));

        StackPane.setMargin(dd.location, new Insets(300, 400, 200, 20));

        StackPane.setMargin(dd.phone_number, new Insets(400, 400, 200, 20));

        StackPane.setMargin(dd.age, new Insets(500, 400, 200, 20));



        StackPane.setMargin(ssss.font_size, new Insets(120, 160, 100, 120));

        StackPane.setMargin(ssss.dark_mode, new Insets(180, 160, 100, 120));

        scene = new Scene(primary_layout, 600, 600);


    }
}