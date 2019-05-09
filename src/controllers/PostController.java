package controllers;


import cards.Post;
import dabasemanager.DatabaseConnectionManager;
import helpMetods.HelpMethods;

import java.sql.*;
public class PostController {
    public Post getPost(String postId) {

        Post post = null;
        Connection connection = DatabaseConnectionManager.getConnection();
        PreparedStatement preparedStatement;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM posts WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,postId);
            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                post = HelpMethods.getDataPost(rs);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  post;
    }


}
