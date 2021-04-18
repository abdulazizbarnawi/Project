/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admineditroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UwU
 */
public class edit {
    private Connection connect() throws SQLException
    {
        Connection con = null;
        String url="jdbc:sqlite:C:/Users/no0o0/Desktop/editadmin.db";
        con = DriverManager.getConnection(url);
        System.out.println("con establoshed...");
        return con;
    }
    public void insertUser (String rid,String rtype,String rcap,String chkin,String chkout,String breakfast) throws SQLException{
        
        String sql = "INSERT INTO edit(roomid,roomtype,roomcap,chkin,chkout,breakfast) VALUES ('"+rid+"','"+rtype+"','"+rcap+"','"+chkin+"','"+chkout+"','"+breakfast+"')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("ROOM SAVED !");
        
    }
    public boolean room(String roomn) throws SQLException {
        String sql = "SELECT roomid,state FROM edit where roomid = '"+roomn+"'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        boolean c = false;
        if(rs.next()){
            String n =rs.getString("roomid");
            String s =rs.getString("state");
            if(roomn.equals(n) && s.equals("Available") ){

             c =true;

            }
        }
        st.close();
        con.close();
        return c;
    }
         public boolean upState (String roomn,boolean avr) throws SQLException{

         if(avr){
         String sql = "UPDATE edit "
                + "set state ='Not available' "
                + "where roomid = '" + roomn + "' ; ";
        //conctions
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("The Room Booked...");
         st.close();
        con.close();
         }

        return avr;
    }



}



    
    
    
    
    




