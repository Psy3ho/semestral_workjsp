package dataAccesObject;

import cards.User;
import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    public String authenticateUser(User user)
    {

        String succes = "Zlé prihlasovacie údaje";

        String email = user.getEmail();
        String password = user.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailDB = "";
        String passwordDB = "";

        try {
            con = DatabaseConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT email,password FROM users");

            while (resultSet.next())
            {
                emailDB = resultSet.getString("email");
                passwordDB = resultSet.getString("password");

                if (email.equals(emailDB) && password.equals(passwordDB)) {
                    succes = "SUCCESS";
                }
            }
        } catch(SQLException e)
            {
                e.printStackTrace();
            }
            return succes;

        }

    }