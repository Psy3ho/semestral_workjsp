package dataAccesObject;

import cards.Post;
import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemovePostDao {
    public String removePost(String id)
    {
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try
        {
            con = DatabaseConnectionManager.getConnection();
            String query = "DELETE FROM posts WHERE id ="+id+";";
            preparedStatement = con.prepareStatement(query);
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
