package UI.Components;

import Modules.NAVBAR;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import sample.INT;
import sample.Main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class NavBar extends HBox {
    INT i = null;
    MyButton products = null;
    MyButton profile = null;
    MyButton wishlist = null;
    MyButton cart = null;
    MyButton settings = null;
    MyButton search = null;
    public NavBar(INT i, NAVBAR pos){
        this.i = i;
        products = new MyButton("products");
        profile = new MyButton("profile");
        wishlist = new MyButton("wishlist");
        cart = new MyButton("cart");
        settings = new MyButton("settings");
        search = new MyButton("search");

        getChildren().addAll(
                products,
                profile,
                wishlist,
                cart,
                settings,
                search
        );
        final String cssDefault = "-fx-border-width: 0 0 1 0; -fx-border-color: red blue #2AC940 yellow;";

        setStyle(cssDefault);

        switch (pos)
        {
            case PRODUCT:
                products.setTextFill(Color.rgb(42,201,64));
                break;
            case CART:
                cart.setTextFill(Color.rgb(42,201,64));
                break;
            case SEARCH:
                search.setTextFill(Color.rgb(42,201,64));
                break;
            case PROFILE:
                profile.setTextFill(Color.rgb(42,201,64));
                break;
            case SETTING:
                settings.setTextFill(Color.rgb(42,201,64));
                break;
            case WISHLIST:
                wishlist.setTextFill(Color.rgb(42,201,64));
                break;
        }
        setHgrow(profile, Priority.ALWAYS);
        setHgrow(products, Priority.ALWAYS);
        setHgrow(search, Priority.ALWAYS);
        setHgrow(settings, Priority.ALWAYS);
        setHgrow(cart, Priority.ALWAYS);
        setHgrow(wishlist, Priority.ALWAYS);

        setAlignment(Pos.TOP_CENTER);
        setMaxHeight(50);



        settings.setOnAction(e->{

            try {

                i.createsettingui();


            }catch (Exception ex){
                ex.printStackTrace();}

        });


        products.setOnAction(e->{

            try {

                i.createProductUI(Main.db_controller.getProducts());
                 } catch (FileNotFoundException ex) {

                ex.printStackTrace();
            } catch (SQLException ex) {
                 ex.printStackTrace();
            }catch (Exception ex){
                ex.printStackTrace();}

        });

        profile.setOnAction(e->{
            try {
                i.createProfileUI(Main.db_controller.getUserInfo(Main.UID));

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
        search.setOnAction(e->{
            try {
                i.createSearchUI();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    }

}
