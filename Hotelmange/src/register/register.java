/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UwU
 */
public class register {
     private Connection connect() throws SQLException
    {
        
        Connection con = null;
        String url="jdbc:sqlite:C:/Users/no0o0/Desktop/register.db";
        con = DriverManager.getConnection(url);
        System.out.println("con establoshed...");
        return con;
    }
    public void insertUser (String nn,String Ee,String ppp) throws SQLException{
        
        String sql = "INSERT INTO register(name,email,password) VALUES ('"+nn+"','"+Ee+"','"+ppp+"')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("the user added");
        
    }
    public boolean login(String name,String password) throws SQLException {
        String sql = "SELECT * FROM register";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        boolean k = false;
        while(rs.next()){
            String n =rs.getString("email");
            String p =rs.getString("password");
            if(name.equals(n) && password.equals(p)) {
                k = true;
                break ;
                
            }

            
        }
        st.close();
        con.close();
         return k;
    
    
}


    
}
