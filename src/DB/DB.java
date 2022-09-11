package DB;

import Modules.Product;
import Modules.Users;
import com.mysql.cj.result.SqlDateValueFactory;
import sample.Main;

import javax.xml.transform.Result;
import java.sql.*;

public class DB {

    /*--------------------------connection-variables------------------------*/

    /**
     * some variables related with connection information
     */

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/jstore";

    static final String USER = "root";

    static final String PASS = "";

    Connection conn = null;

    Statement stmt = null;

    PreparedStatement pstmt = null;

    ResultSet rs;

    /*--------------------------constructors-------------------------------*/

    /**
     * default constructor to create connection
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DB() throws SQLException, ClassNotFoundException {

        connect();

    }



    /*--------------------------general-function-------------------------------*/


    /**
     * @return *void*
     * connect to database with username root
     * and no password for local preivilages
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public void connect() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database...");

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Creating statement...");

        stmt = conn.createStatement();

    }


    /**
     * close and delete the values of connection variables
     *
     * @return *void*
     * @throws SQLException
     */

    public void close() throws SQLException {

        if (conn == null) throw new SQLException("connection is already closed");

        rs.close();

        stmt.close();

        conn.close();

    }



    /*--------------------------user-table-functions-------------------------------*/


    /**
     * used to give you result set from "users" table in data base containing users information
     *
     * @return *Resultset*
     * @throws SQLException
     */

    public ResultSet showUsers() throws SQLException {

        if (conn == null) throw new SQLException("connect failure");

        String query = "SELECT * FROM users WHERE 1";

        rs = stmt.executeQuery(query);

        while (rs.next()) {

            System.out.println("full name :" + rs.getString("full_name"));

            System.out.println("phone number :" + rs.getString("phone_number"));

            System.out.println("age :" + rs.getInt("age"));

            System.out.println("created at :" + rs.getTimestamp("created_at"));

            System.out.println("========================================================");


        }

        return rs;

    }


    public Users userInfo(int ID) throws SQLException {

        if (conn == null) throw new SQLException("connect failure");

        String query = "SELECT * FROM users WHERE ID=?";
        pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();

        return generateUserModule(rs);

    }


    /**
     * used to add user to the table in data base
     *
     * @param 'name'
     * @param 'number'
     * @param 'password'
     * @param 'age'
     * @param 'location'
     * @return *void*
     * @throws SQLException
     */

    public void addUser(String name, String number, String password, int age, String location) throws SQLException {

        if (conn == null) throw new SQLException("connection failure");

        String query = "INSERT INTO `users` ( `full_name`, `phone_number`, `password`, `age`, `location`) VALUES (?,?,?,?,?)";

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1, name);

        pstmt.setString(2, number);

        pstmt.setString(3, password);

        pstmt.setInt(4, age);

        pstmt.setString(5, location);

        pstmt.executeUpdate();

    }

    /**
     * used to change user information in the table of data base
     *
     * @param 'name'
     * @param 'number'
     * @param 'password'
     * @param 'age'
     * @param 'location'
     * @param 'id'
     * @return *boolean*
     * @throws SQLException
     */
    public boolean updateUser(String name, String number, String password, int age, String location, int id) throws SQLException {

        if (conn == null) throw new SQLException("connection failure");

        String query = "update `users` set full_name = ? , phone_number = ? , password = ? , age = ? , location = ? WHERE ID = ?";

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1, name);

        pstmt.setString(2, number);

        pstmt.setString(3, password);

        pstmt.setInt(4, age);

        pstmt.setString(5, location);

        pstmt.setInt(6, id);

        return pstmt.execute();

    }


    /**
     * to delete a user from table in data base
     *
     * @param 'id'
     * @return *boolean*
     * @throws SQLException
     */

    public boolean deleteUser(int id) throws SQLException {

        if (conn == null) throw new SQLException("connection failure");

        String query = "Delete FROM users WHERE id = ?";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1, id);

        return pstmt.execute();
    }

    public   Users create_account(String full_name,String phone_number , String password,String age,String location) throws SQLException {

        if (conn == null) throw new SQLException("connect failure");

        String query = "INSERT INTO `users`(`full_name`, `phone_number`, `password`, `age`, `location`) VALUES (?,?,?,?,?)";

        pstmt=conn.prepareStatement(query);


        pstmt.setString(1, full_name);
        pstmt.setString(2, phone_number);
        pstmt.setString(3, password);
        pstmt.setString(5, age);
        pstmt.setString(4,location);
        int result=  pstmt.executeUpdate();
        if(result==1)
        {
            System.out.println("inserted....................");
        }

        pstmt.close();
return  null;


    }



    public Users checkUser(String name, String password) throws SQLException{

        if(conn == null) throw new SQLException("connect failure");

        String query = "SELECT * FROM users WHERE full_name=? AND password=?";
        pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setString(1,name);
        pstmt.setString(2,password);
        rs = pstmt.executeQuery();

        return generateUserModule(rs);


    }


    public Users generateUserModule(ResultSet rs) throws SQLException {
        rs.last();
        int rowNum = rs.getRow();
        if (rowNum != 0) {
            rs.first();
            Users users = new Users(rs.getInt("ID"), rs.getString("full_name"), rs.getString("phone_number"),rs.getString("password"), rs.getString("age"), rs.getString("location"));
            return users;
        }
        return null;
    }





    /*--------------------------product-table-functions-------------------------------*/



    /**
     * give you a result set from the table in data base containing product information
     * @return *result set*
     * @throws SQLException
     */


    public Product[] fetchProducts() throws SQLException{
        if(conn == null) throw new SQLException("connection failure");
        String query = "SELECT * FROM product";
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery(query);
       return generateProductModule(rs);
    }

    public Product[] generateProductModule(ResultSet rs) throws SQLException {
        int i = 0;
        rs.last();
        Product[] products = new Product[rs.getRow()];
        rs.beforeFirst();
        while(rs.next())
        {
            products[i] = new Product(rs.getString("tittle"),rs.getString("price"),rs.getString("decripe"),rs.getString("img"),false,false);
            i++;
        }

        return products;
    }

    private boolean checkProductInWishlist(int pid, int uid) throws SQLException {
        if(conn == null) throw new SQLException("connection failure");

        String query = "SELECT * FROM `wish_list` WHERE `product_id` = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1,pid);
       // pstmt.setInt(2,uid);
        ResultSet rs = stmt.executeQuery(query);
        return rs == null ? false : true;

    }



    /*--------------------------brand-table-functions-------------------------------*/



    /**
     * give you result set from the table in data base containing brand information
     * @return *result set*
     * @throws SQLException
     */

    public ResultSet fetchBrands() throws SQLException{
        if(conn == null) throw new SQLException("connection failure");

        String query = "SELECT * FROM brand ORDER BY rating LIMIT 10";

        rs = stmt.executeQuery(query);

        return rs;
    }



    /*--------------------------wishlist-table-functions-------------------------------*/


    /**
     * give you result set from the table in data base containing product information from wish list table
     * @return *result set*
     * @throws SQLException
     */

    public ResultSet fetchWishList()throws SQLException{
        if(conn == null) throw new SQLException("connection failure");

        String query = "SELECT * FROM wish_list ORDER BY date LIMIT 10";

        rs = stmt.executeQuery(query);

        return rs;

    }


    /**
     * this function use to add a specific item to
     * wish list table in database
     * @param 'u_id'  user ID
     * @param 'p_id'  product ID
     * @return *boolean*
     * @throws SQLException
     */

    public boolean addItemToWishList(int u_id, int p_id) throws SQLException{

        if(conn == null) throw new SQLException("connection failure");

        String query = "INSERT INTO `wish_list` ( `product _id`,`user_id`) VALUES (?,?)";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1,p_id);

        pstmt.setInt(2,u_id);

        return  pstmt.execute();

    }

    /**
     * this function use to delete a specific item to
     * wish list table in database
     * @param 'id' ID of the item that i would delete it
     * @return *boolean*
     * @throws SQLException
     */

    public boolean deleteItemFromWishList(int id) throws SQLException{

        if(conn == null) throw new SQLException("connection failure");

        String query = "Delete FROM wish_list WHERE id = ?";

        pstmt  = conn.prepareStatement(query);

        pstmt.setInt(1,id);

        return pstmt.execute();

    }



    /*--------------------------history-table-functions-------------------------------*/


    /**
     * add one item to history table using id of the product and
     * id of the user and name of the deliver man
     * @param 'id_product'
     * @param user_id
     * @param 'deliver_name'
     * @throws SQLException
     */

    public void addHistory (int id_product,int user_id,String deliver_name)throws SQLException{

        if(conn == null) throw new SQLException("connect failure");

        pstmt = conn.prepareStatement("INSERT INTO `history`( `productid`, `userid`, `delivername`) VALUES (?,?,?)");

        pstmt.setInt(1,id_product);

        pstmt.setInt(2,user_id);

        pstmt.setString(3,deliver_name);

        pstmt.execute();

        pstmt = null;
    }

    /**
     * gives result set of product information in history table
     * @return *Result set* of the 10 products
     * @throws SQLException
     */

    public ResultSet fetchHistory() throws SQLException{

        if(conn == null) throw new SQLException("connect failure");

        int num_of_product = 10;

        pstmt = conn.prepareStatement("SELECT * FROM `history` WHERE ?");

        pstmt.setInt(1,num_of_product);

        return pstmt.executeQuery();

    }

    /* TOMORROW  **/
    public Product[] fetchUserHistory(int ID) throws SQLException{

        if(conn == null) throw new SQLException("connect failure");

        int num_of_product = 10;

        pstmt = conn.prepareStatement("SELECT * FROM `product` WHERE id IN (SELECT productid FROM `HISTORY` WHERE userid=?)",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        pstmt.setInt(1,ID);

        rs = pstmt.executeQuery();


        return generateProductModule(rs);

    }


    /*--------------------------settings-table-functions-------------------------------*/

    /**
     * give you an result set from setting table in data base
     * @return *resultset*
     * @throws SQLException
     */
    public ResultSet fetchSetting() throws SQLException {
        if(conn == null) throw new SQLException("connect failure");

        String query = "SELECT * FROM settings WHERE 1";

        rs = stmt.executeQuery(query);

        return rs;

    }

    /**
     *
     * @param 'U_ID'
     * @param 'color'
     * @param 'font_size'
     * @param 'grid'
     * @throws SQLException
     */

    public void addSetting( int U_ID , int color , int font_size , int grid ) throws SQLException{
        if(conn == null) throw new SQLException("connect failure");

        String query = "INSERT INTO `settings`(`uid`, `primarycolor`, `fontsize`, `grid`) VALUES (?,?,?,?)";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1,U_ID);

        pstmt.setInt(2,color);

        pstmt.setInt(3,font_size);

        pstmt.setInt(4,grid);

        pstmt.executeUpdate();

    }

    /**
     * edit setting information in data base //only//
     * @param 'id'
     * @param 'U_ID'
     * @param 'color'
     * @param 'font_size'
     * @param 'grid'
     * @return *boolean*
     * @throws SQLException
     */

    public boolean updateSetting( int id , int U_ID , int color , int font_size , int grid ) throws SQLException{
        if(conn == null) throw new SQLException("connect failure");

        String query = "UPDATE `settings` set uid = ? , primarycolor = ? , fontsize = ? , grid = ? WHERE id = ? ";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1,U_ID);

        pstmt.setInt(2,color);

        pstmt.setInt(3,font_size);

        pstmt.setInt(4,grid);

        pstmt.setInt(5,id);

        return pstmt.execute();
    }

    /**
     * delete settings
     * @param 'id'
     * @return
     * @throws SQLException
     */

    public boolean deleteSetting(int id)throws SQLException{

        if(conn == null) throw new SQLException("connection failure");

        String query = "Delete FROM settings WHERE id = ?";

        pstmt  = conn.prepareStatement(query);

        pstmt.setInt(1,id);

        return pstmt.execute();
    }
}

