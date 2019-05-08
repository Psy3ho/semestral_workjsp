package dataAccesObject;

import cards.Post;
import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditPostDao {
    public String addPost(Post post)
    {
        String title = post.getTitle();
        String text = post.getText();
        String image = post.getImage();
        String id = post.getId();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try
        {
            con = DatabaseConnectionManager.getConnection();

            String query = "UPDATE posts SET title ='"+title+"', text ='"+text+"',image ='"+image+"' WHERE id ="+id+";";

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
