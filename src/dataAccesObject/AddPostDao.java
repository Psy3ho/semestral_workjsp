package dataAccesObject;

import cards.Post;
import dabasemanager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("ALL")
public class AddPostDao {
    public String addPost(Post post)
    {
        String title = post.getTitle();
        String text = post.getText();
        String image = post.getImage();
        String user_id = post.getUserId();

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try
        {
            con = DatabaseConnectionManager.getConnection();
            String query = "INSERT INTO posts(user_id,title,text,image) VALUES (?,?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, text);
            preparedStatement.setString(4, image);
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
