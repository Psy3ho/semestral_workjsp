package dataAccesObject;

import cards.Post;
import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("Duplicates")
public class EditPostDao {
    public String addPost(Post post)
    {
        String title = post.getTitle();
        String text = post.getText();
        String image = post.getImage();
        String id = post.getId();

        Connection con;
        PreparedStatement preparedStatement;
        String query;

        try
        {
            con = DatabaseConnectionManager.getConnection();

            if(image != null) {
                query = "UPDATE posts SET title = ?, text = ?,image = ? WHERE id =?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,title);
                preparedStatement.setString(2,text);
                preparedStatement.setString(3,image);
                preparedStatement.setString(4,id);
            } else {
                query = "UPDATE posts SET title = ?, text =? WHERE id =?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,title);
                preparedStatement.setString(2,text);
                preparedStatement.setString(3,id);
            }
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
