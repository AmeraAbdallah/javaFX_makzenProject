/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makzenproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Amera
 */
public class DB {
    static final String JDBC_driver="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/itse423";
    static final String USER="root";
    static final String PASS="";
    public static Connection Connect() 
    {
        try
        {
            Connection conn = null;
            Class.forName(JDBC_driver);
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            return conn;
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("some thing wrong");
            alert.setHeaderText("Alert !");
            alert.setContentText(ex.toString());
            alert.show();
            System.out.println("here 1 "+ex);
            return null;
        }
    }
}
