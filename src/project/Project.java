package project;

import models.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import models.Feedback;
import models.Place;

public class Project extends Application {

    public static User currentUser;
    public static Connection con;
    static Stage stage = null;
    public static ObservableList<Place> places = FXCollections.observableArrayList();
    public static ObservableList<User> userList = FXCollections.observableArrayList();
    public static ObservableList<Feedback> feedList = FXCollections.observableArrayList();

    public static void changeView(String view, String title) {

        Parent root;
        try {
            root = FXMLLoader.load(Project.class.getClass().getResource(view));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.hide();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void showAlert(String title, String content, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    }

    

    public static void deletUser(int id) {

        try {
            String sql = "DELETE FROM USERS WHERE ID=" + id;
            Connection con = connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);

            System.out.println("the user added");
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteFeed(int id) {
  
      try {
            String sql = "DELETE FROM feedback WHERE ID=" + id;
            Connection con = connect();
            Statement st = con.createStatement();
            st.executeUpdate(sql);

             
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage appStage) throws Exception {

        stage = appStage;
        changeView("/views/MainPage.fxml", "Main Page");

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Connection connect() throws SQLException {

        if (con != null) {
            return con;
        }
        String url = "jdbc:sqlite:registerG.db";
        con = DriverManager.getConnection(url);
        System.out.println("con establoshed...");
        return con;
    }

    public static void insertUser(String n, String p, String e, String phone) throws SQLException {

        String sql = "INSERT INTO users(name,password,email,phone) VALUES ('" + n + "','" + p + "','" + e + "','" + phone + "')";
        Connection con = connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
  
        System.out.println("the user added");

    }

    public static void insertPlace(String name, String info, String best, int area) {

        try {
            String sql = "INSERT INTO places(name, info,  best,  area )  VALUES (?,?,?,?)";
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, info);
            ps.setString(3, best);
            ps.setInt(4, area);
            ps.executeUpdate();

        } catch (SQLException e) {

        }

    }

    public static void loadPlaces() {
        int id, area;
        String name, info, best;
        places.clear();
        try {

            Connection con = connect();
            String query = "SELECT * from places   ";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                id = results.getInt("id");
                area = results.getInt("area");

                name = results.getString("name");
                info = results.getString("info");
                best = results.getString("best");
                Place p = new Place(id, area, name, info, best);

                places.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadFeeds() {
        int id;
        String name, email, q1, q2, q3, q4, q5, q6;
        feedList.clear();
        try {

            Connection con = connect();
            String query = "SELECT * from feedback   ";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                id = results.getInt("id");

                name = results.getString("name");
                email = results.getString("email");
                q1 = results.getString("q1");
                q2 = results.getString("q2");
                q3 = results.getString("q3");
                q4 = results.getString("q4");
                q5 = results.getString("q5");
                q6 = results.getString("q6");
                Feedback f = new Feedback(id,  name,  email,  q1,  q2,  q3,  q4,  q5,  q6);
//  public Feedback(int id, String name, String email, String q1, String q2, String q3, String q4, String q5, String q6) {
  
                feedList.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadUsers() {
        int id;
        String name, email, password, phone;
        userList.clear();
        try {

            Connection con = connect();
            String query = "SELECT * from users   ";

            PreparedStatement ps = con.prepareStatement(query);
//String name, String password, String email, String phone)
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                id = results.getInt("id");
                email = results.getString("email");

                name = results.getString("name");
                password = results.getString("password");
                phone = results.getString("phone");
                User p = new User(id, name, password, email, phone);

                userList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int updatePlace(int id, int area,String name, String info, String best) {

        try {
            Connection con = connect();
            String query = "update   Places   set area=?,name=? ,info=?, best=?   where id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, area);
             ps.setString(2, name);
            ps.setString(3, info);
            ps.setString(4, best);
            ps.setInt(5, id);
            int res = ps.executeUpdate();
            System.out.println("res " + res);
            //insert or update or delete
            return res;//5 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static int deletePlaces(int id) {

        try {
            Connection con = connect();
            String query = "delete from   Places    where id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            int res = ps.executeUpdate();
            System.out.println("res " + res);
            //insert or update or delete
            return res;//5 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int register(User user) {

        try {
            Connection con = connect();
            String query = "INSERT INTO users ( name, email,phone, password ) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());//4
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());

            ps.setString(4, user.getPassword());
            int res = ps.executeUpdate();
            System.out.println("res " + res);
            //insert or update or delete
            return res;//5 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int login(String email, String password) {

        try {
            Connection con = connect();

            String query = "SELECT  *  FROM  users  WHERE  email=? AND  password=?  ";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");

                String phone = result.getString("phone");
//id, String name, String password, String email, String phone
                currentUser = new User(id, name, password, email, phone);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public static Place getPlace(String name) {
        int id, area;
        String info, best;

        try {

            Connection con = connect();
            String query = "SELECT * from places  Where name Like'%" + name + "%'";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet results = ps.executeQuery();
            if (results.next()) {
                id = results.getInt("id");
                area = results.getInt("area");

                name = results.getString("name");
                info = results.getString("info");
                best = results.getString("best");
                return new Place(id, area, name, info, best);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int insertFeed(String name, String email, String q1, String q2, String q3, String q4, String q5, String q6) {

        try {
            Connection con = connect();
            String query = "INSERT INTO Feedback (name,email,q1,q2,q3,q4,q5,q6)       VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, q1);
            ps.setString(4, q2);
            ps.setString(5, q3);
            ps.setString(6, q4);
            ps.setString(7, q5);
            ps.setString(8, q6);
            int res = ps.executeUpdate();
            System.out.println("res " + res);
            //insert or update or delete
            return res;//5 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
