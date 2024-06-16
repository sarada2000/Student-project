/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBSearch {

    Statement stmt;
    ResultSet rs;

    public ResultSet searchLogin(String usName) {
        try {
            stmt = DBConnection.getStatementConnection();
            String name = usName;
            // Execute the Query
            rs = stmt.executeQuery("SELECT * FROM login WHERE username='" + name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        DBSearch dbSearch = new DBSearch();
        ResultSet result = dbSearch.searchLogin("testuser");

        try {
            while (result.next()) {
                // Assuming 'login' table has 'username' and 'password' columns
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DBconection{
    public static Statement getStatementConnection() {
        Statement stmt = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
}
/**
 *
 * @author user
 */
