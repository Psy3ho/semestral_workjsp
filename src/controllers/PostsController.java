package controllers;

import cards.Post;
import dabasemanager.DatabaseConnectionManager;
import helpMetods.HelpMethods;

import java.sql.*;
import java.util.ArrayList;
public class PostsController {
    public ArrayList<Post> getPosts(int page) {

        ArrayList<Post> listPosts = new ArrayList<>();
        Connection connection = DatabaseConnectionManager.getConnection();
        Statement s;
        ResultSet rs;

        int posts = 5;

        try {
            s = connection.createStatement();
            String sql = "SELECT * FROM posts ORDER BY created_at DESC LIMIT " + posts + " OFFSET " + page*posts + ";";
            rs = s.executeQuery(sql);
            while(rs.next()){
                listPosts.add(HelpMethods.getDataPost(rs));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listPosts;

    }
}
