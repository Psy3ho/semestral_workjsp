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
        PreparedStatement preparedStatement;
        ResultSet rs;

        int posts = 5;

        try {

            String sql = "SELECT * FROM posts ORDER BY created_at DESC LIMIT ? OFFSET ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,posts);
            preparedStatement.setInt(2,posts*page);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                listPosts.add(HelpMethods.getDataPost(rs));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listPosts;

    }

    public ArrayList<Post> getPostsByDate(String date1, String date2) {

        ArrayList<Post> listPosts = new ArrayList<>();
        Connection connection = DatabaseConnectionManager.getConnection();
        PreparedStatement preparedStatement;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM posts WHERE created_at >= ? and created_at  <= ? ORDER BY created_at ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1,HelpMethods.getTimestampFromString(date1));
            preparedStatement.setTimestamp(2,HelpMethods.getTimestampFromString(date2));
            rs = preparedStatement.executeQuery();
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
