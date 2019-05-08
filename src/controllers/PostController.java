package controllers;


import cards.Post;
import dabasemanager.DatabaseConnectionManager;
import helpMetods.HelpMethods;

import java.sql.*;
public class PostController {
    public Post getPost(String postId) {

        Post post = null;
        Connection connection = DatabaseConnectionManager.getConnection();
        Statement s;
        ResultSet rs;

        try {
            s = connection.createStatement();
            String sql = "SELECT * FROM posts WHERE id ="+postId+";";
            rs = s.executeQuery(sql);
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
