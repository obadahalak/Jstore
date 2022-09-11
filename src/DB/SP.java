package com.company;

import java.sql.*;

public class SP {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/jstore";

    // Database credentials

    static final String USER = "root";

    static final String PASS = "";

    Connection conn = null;

    Statement stmt = null;

    PreparedStatement pstmt = null;

    ResultSet rs;

    Savepoint sp = null;

    public SP() throws SQLException, ClassNotFoundException {
        connect();
    }

    public void connect() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database...");

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Creating statement...");

        stmt = conn.createStatement();

        conn.setAutoCommit(false);


    }

    public void test() throws SQLException, ClassNotFoundException {
        addUser("dre","ewr","dasd",5,"test");
        addUser("dre","ewr","dasd",5,"test");
        addUser("dre","ewr","dasd",5,"test");
        sp = conn.setSavepoint("v1");
        addUser("test","ewr","dasd", 100,"test");
        conn.rollback(sp);
        conn.commit();
        conn.close();

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

}
