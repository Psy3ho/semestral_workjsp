package controllers;

import cards.User;
import dabasemanager.DatabaseConnectionManager;
import helpMetods.HelpMethods;

import java.sql.*;

public class UserController {
    public User getUser(String userId) {

        User user = null;
        Connection connection = DatabaseConnectionManager.getConnection();
        Statement s;
        ResultSet rs;

        try {
            s = connection.createStatement();
            String sql = "SELECT * FROM users WHERE id ="+userId+";";
            rs = s.executeQuery(sql);
            if(rs.next()) {
                user = HelpMethods.getDataUser(rs);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  user;
    }

    public User getUserEmail(String email) {

        User user = null;
        Connection connection = DatabaseConnectionManager.getConnection();
        Statement s;
        ResultSet rs;

        try {
            s = connection.createStatement();
            String emailString = "'"+email+"'";
            String sql = "SELECT * FROM users WHERE email = "+emailString+";";
            rs = s.executeQuery(sql);
            if(rs.next()) {
                user = HelpMethods.getDataUser(rs);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  user;
    }
}
