package dataAccesObject;

import cards.User;
import dabasemanager.DatabaseConnectionManager;
import org.mindrot.jbcrypt.BCrypt;

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

        Connection con;
        Statement statement;
        ResultSet resultSet ;

        String emailDB;
        String passwordDB;

        try {
            con = DatabaseConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT email,password FROM users");

            while (resultSet.next())
            {
                emailDB = resultSet.getString("email");
                passwordDB = resultSet.getString("password");

                if (email.equals(emailDB) && BCrypt.checkpw(password, passwordDB)) {
                    succes = "SUCCESS";
                }
            }
            con.close();
        } catch(SQLException e)
            {
                e.printStackTrace();
            }
            return succes;

        }

    }