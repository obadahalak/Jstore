package Modules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import UI.Components.label;
import UI.Components.slider;
import com.jfoenix.controls.JFXButton;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import javax.print.attribute.standard.MediaSize;
import java.awt.*;

public class settingg {
    private Button edit = null;
    private String font_size = null;
    private String dark_mode = null;
    private String full_name = null;
    private String location = null;
    private String phone_number = null;
    private String password = null;
    private String age = null;
    private slider slider=null;
    private Button  logout = null;

    public UI.Components.slider getSlider() {
        return slider;
    }

    public void setSlider(UI.Components.slider slider) {
        this.slider = slider;
    }

    public Button getLogout() {
        return logout;
    }

    public void setLogout(Button logout) {
        this.logout = logout;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String getFont_size() {
        return font_size;
    }

    public void setFont_size(String font_size) {
        this.font_size = font_size;
    }

    public String getDark_mode() {
        return dark_mode;
    }

    public void setDark_mode(String dark_mode) {
        this.dark_mode = dark_mode;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



}
