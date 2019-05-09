package dataAccesObject;

import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemovePostDao {
    public String removePost(String id)
    {
        Connection con;
        PreparedStatement preparedStatement;

        try
        {
            con = DatabaseConnectionManager.getConnection();
            String query = "DELETE FROM posts WHERE id =?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,id);
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
