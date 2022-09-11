package sample;

import Modules.Product;
import Modules.Users;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface INT {
    public void initializeProducts(Product[] items);
    public void createProductUI(Product[] items) throws FileNotFoundException;
    public void createProfileUI(Users user) throws FileNotFoundException, SQLException;
    public void createFirstUI();
    public  void createSearchUI() throws SQLException, FileNotFoundException;
    public void createSignInUI();
    public void createSignUpUI();
    public void createsettingui() throws FileNotFoundException, SQLException, ClassNotFoundException;
}
