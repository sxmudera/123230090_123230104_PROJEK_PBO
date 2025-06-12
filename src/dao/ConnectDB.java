package dao;

import java.sql.*;

public class ConnectDB {

    public static Connection getConnection(){
        Connection conn = null;
        String DBurl = "jdbc:mysql://localhost/todolist";
        String DBun = "root";
        String DBpw = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBun, DBpw);
        }catch (ClassNotFoundException | SQLException e){
            System.err.println("Gagal menghubungkan ke database");
        }
        return conn;

    }
}
