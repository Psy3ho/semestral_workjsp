package controllers;

import cards.User;
import dabasemanager.DatabaseConnectionManager;
import helpMetods.HelpMethods;

import java.sql.*;

@SuppressWarnings("Duplicates")
public class UserController {
    public User getUser(String userId) {

        User user = null;
        Connection connection = DatabaseConnectionManager.getConnection();
        PreparedStatement preparedStatement;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM users WHERE id =?";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            rs = preparedStatement.executeQuery();
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
        PreparedStatement preparedStatement;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            rs = preparedStatement.executeQuery();
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
