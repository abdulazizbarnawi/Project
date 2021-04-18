/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg439005074;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author UwU
 */
public class data {
    private Connection connect() throws SQLException
    {
        
        Connection con = null;
        String url="jdbc:sqlite:C:/Users/no0o0/Desktop/439005074.db";
        con = DriverManager.getConnection(url);
        System.out.println("con establoshed...");
        return con;
    }
    public void insertUser (String vname,String cname,String year) throws SQLException{
        
        String sql = "INSERT INTO Cars(Vname,Cname,year) VALUES ('"+vname+"','"+cname+"','"+year+"')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("the user added");
        
    }
    public class tabel {
    private String vname;
    private String cname;

    public tabel (String vname,String cname){
        this.vname=vname;
        this.cname=cname;


        
    }

   

        public String getVname() {
            return vname;
        }

        public void setVname(String vname) {
            this.vname = vname;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

      

        

     
}
    public void UsersData(ObservableList oblist) throws SQLException
        {
            String sql = "SELECT * FROM Cars";
            try{
            Connection con = this.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
//            {
                oblist.add(new tabel(rs.getString("Vname"),rs.getString("Cname")));
//            }
            st.close();
            con.close();
            //return rs;
            
        }
            catch(Exception e){
                e.printStackTrace();
            }
       
}
   
}
