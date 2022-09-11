package DB;

import Modules.Product;
import Modules.Users;
import javafx.application.Platform;
import sample.INT;
import sample.Main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class DBController implements Runnable {
    DB db = null;
    INT i = null;

    public DBController(INT i) throws SQLException, ClassNotFoundException {
        this.i = i;
        db = new DB();


    }
    public Product[] getUserHistory(int ID) throws SQLException {
        return db.fetchUserHistory(ID);
    }

    public Users getUserInfo(int ID) throws SQLException {
        return db.userInfo(ID);
    }
    public Product[] getProducts() throws SQLException {
        return  db.fetchProducts();

    }
    public Users checkUser(String name, String password) throws SQLException {
        return db.checkUser(name, password);
    }
    public Users create_user(String full_name, String password, String phone_number, String location, String age) throws SQLException {
        return db.create_account(full_name, password, phone_number, location, age);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
           Platform.runLater(new Runnable() {
               @Override
               public void run() {
                   try {
                       i.createProductUI(db.fetchProducts());

                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
           });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true)
        {


        }
    }

}
