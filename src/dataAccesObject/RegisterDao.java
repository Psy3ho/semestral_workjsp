package dataAccesObject;


import cards.User;
import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    public String registerUser(User user)
    {
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();

        Connection con;
        PreparedStatement preparedStatement;

        try
        {
            con = DatabaseConnectionManager.getConnection();
            String query = "INSERT INTO users(name,email,password) VALUES (?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();

            con.close();


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}