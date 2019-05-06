package controllers;

import cards.Post;
import dabasemanager.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
public class PostsController {
    public ArrayList<Post> getPosts() {
        ArrayList<Post> listPosts = new ArrayList<>();
        Connection connection = DatabaseConnectionManager.getConnection();
        Statement s = null; // objekt pre prikaz sql -> klasicky sql prikaz
        ResultSet rs = null; // objekt pre ulozenie vysledkov z databazy
        PreparedStatement ps = null;
        try {
            s = connection.createStatement();

            String sql = "SELECT * FROM posts;";
            rs = s.executeQuery(sql);
            while(rs.next()){
                Integer id = rs.getInt("id");
                String user_id = rs.getString("user_id");
                String title = rs.getString("title");
                String text = rs.getString("text");
                String slug = rs.getString("slug");
                String image = rs.getString("image");
                String date = rs.getString("created_at");
                Post post = new Post(id,user_id,title,text,slug,image,date);
                listPosts.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listPosts;

    }
}
