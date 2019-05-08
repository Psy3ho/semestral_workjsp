package controllers;

import cards.User;
import dabasemanager.DatabaseConnectionManager;
import helpMetods.HelpMethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserEmailController {
    public User getUser(String email) {

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
