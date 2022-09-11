package DB;

import com.mysql.cj.xdevapi.UpdateStatement;

import java.sql.*;

public class DBB {

    /*--------------------------connection-variables------------------------*/

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/jstore";

    // Database credentials

    static final String USER = "root";

    static final String PASS = "";

    Connection conn = null;

    Statement stmt = null;

    PreparedStatement pstmt = null;

    ResultSet rs;

    /*--------------------------constructors-------------------------------*/

    public DBB() throws SQLException, ClassNotFoundException {

        connect();

    }

    /*--------------------------general-function-------------------------------*/


    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @return *void*
     * connect to database with username root
     * and no password for local preivilages
     *
     */

    public void connect() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database...");

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Creating statement...");

        stmt = conn.createStatement();

    }

    public void close() throws SQLException{

        if(conn == null) throw new SQLException("connection is already closed");

        rs.close();

        stmt.close();

        conn.close();

    }

    /*--------------------------user-table-functions-------------------------------*/

    public ResultSet showUsers() throws SQLException{

        if(conn == null) throw new SQLException("connect failure");

        String query = "SELECT * FROM users WHERE 1";

        rs = stmt.executeQuery(query);

        while(rs.next())
        {

            System.out.println("full name :" + rs.getString("full_name"));

            System.out.println("phone number :" + rs.getString("phone_number"));

            System.out.println("age :" + rs.getInt("age"));

            System.out.println("created at :" + rs.getTimestamp("created_at"));


        }

        return rs;

    }


    public void addUser(String name,String number,String password,int age,String location) throws SQLException {

        if(conn == null) throw new SQLException("connection failuer");

        String query = "INSERT INTO `users` ( `full_name`, `phone_number`, `password`, `age`, `location`) VALUES (?,?,?,?,?)";

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1,name);

        pstmt.setString(2,number);

        pstmt.setString(3,password);

        pstmt.setInt(4,age);

        pstmt.setString(5,location);

        pstmt.executeUpdate();

    }

    public boolean updateUser( String name,String number,String password,int age,String location, int id ) throws SQLException{

        if(conn == null) throw new SQLException("connection failure");

        String query = "update `users` set full_name = ? , phone_number = ? , password = ? , age = ? , location = ? WHERE ID = ?";

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1,name);

        pstmt.setString(2,number);

        pstmt.setString(3,password);

        pstmt.setInt(4,age);

        pstmt.setString(5,location);

        pstmt.setInt(6,id);

        return pstmt.execute();

    }

    public boolean deleteUser(int id) throws SQLException{

        if(conn == null) throw new SQLException("connection failuer");

        String query = "Delete FROM users WHERE id = ?";

        pstmt  = conn.prepareStatement(query);

        pstmt.setInt(1,id);

        return pstmt.execute();
    }

    /*--------------------------product-table-functions-------------------------------*/

    public ResultSet fetchProducts() throws SQLException{

        String query = "SELECT * FROM product ORDER BY rating LIMIT 10";

        rs = stmt.executeQuery(query);

        return rs;
    }

    /*--------------------------brand-table-functions-------------------------------*/

    public ResultSet fetchBrands() throws SQLException{

        String query = "SELECT * FROM brand ORDER BY rating LIMIT 10";

        rs = stmt.executeQuery(query);

        return rs;
    }

    /*--------------------------wishlist-table-functions-------------------------------*/

    public ResultSet fetchWishList()throws SQLException{

        String query = "SELECT * FROM wishlist ORDER BY rating LIMIT 10";

        rs = stmt.executeQuery(query);

        return rs;

    }

    public boolean addItemToWishList(int u_id, int p_id) throws SQLException{

        if(conn == null) throw new SQLException("connection failuer");

        String query = "INSERT INTO `wishlist` ( `product _id`,`user_id`) VALUES (?,?)";

        pstmt = conn.prepareStatement(query);

        pstmt.setInt(1,p_id);

        pstmt.setInt(2,u_id);

        return  pstmt.execute();

    }

    public boolean deleteItemFromWishList(int id) throws SQLException{

        if(conn == null) throw new SQLException("connection failuer");

        String query = "Delete FROM wishlist WHERE id = ?";

        pstmt  = conn.prepareStatement(query);

        pstmt.setInt(1,id);

        return pstmt.execute();

    }


}
