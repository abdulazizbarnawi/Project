/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UwU
 */
public class hotelusers {
    private Connection connect() throws SQLException
    {
        Connection con = null;
        String url="jdbc:sqlite:C:/Users/no0o0/Desktop/Hotelmange.db";
        con = DriverManager.getConnection(url);
        System.out.println("con establoshed...");
        return con;
    }
    public void insertUser (String n,String E,String pp) throws SQLException{
        
        String sql = "INSERT INTO users(NAME,EMAIL,passport) VALUES ('"+n+"','"+E+"','"+pp+"')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("the user added");
        
    }
}
