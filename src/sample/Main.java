package sample;

import DB.DBController;
import Modules.Product;
import Modules.Users;
import UI.Pages.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.SQLException;


public class Main extends Application implements INT {
public static int UID = -1;
public Product[] POPULAR_ITEMS = null;
Products products = null;
Stage stage = null;
Splash splash = null;
public static DBController db_controller = null;
Profile profile = null;
StartPage startPage = null;
Search search = null;
Sign_in sign_in = null;
Sign_up sign_up = null;
settings Settings=null;
public static Users user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        db_controller = new DBController(this);
        this.stage = primaryStage;
        splash = new Splash();
        primaryStage.setIconified(false);
        primaryStage.setScene(splash.scene);
        primaryStage.show();
        Thread db = new Thread(db_controller);
        db.start();





    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void initializeProducts(Product[] items) {
        POPULAR_ITEMS = items;
    }

    @Override
    public void createProductUI(Product[] items) throws FileNotFoundException {
         products = new Products(items,this);
        stage.setScene(products.scene);


    }
    @Override
    public void createProfileUI(Users user) throws FileNotFoundException, SQLException {
        if (UID == -1)
            createFirstUI();
        else {
            profile = new Profile(this, user, db_controller.getUserHistory(UID));
            stage.setScene(profile.scene);
        }

    }

    @Override
    public void createFirstUI() {
        startPage = new StartPage(this);
        stage.setScene(startPage.scene);
    }

    @Override
    public void createSearchUI() throws SQLException, FileNotFoundException {
        search = new Search(this, db_controller.getUserHistory(UID));
        stage.setScene(search.scene);
    }

    @Override
    public void createSignInUI() {
        sign_in = new Sign_in(this);
        stage.setScene(sign_in.scene);
    }
    @Override
    public void createSignUpUI() {
        sign_up = new Sign_up(this);
        stage.setScene(Sign_up.scene);
    }

    @Override
    public void createsettingui() throws FileNotFoundException, SQLException, ClassNotFoundException {
        Settings=new settings(this);
       stage.setScene(settings.scene);
    }
}
