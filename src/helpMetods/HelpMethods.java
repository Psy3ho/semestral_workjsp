package helpMetods;

import cards.Post;
import cards.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HelpMethods {

    public static Post getDataPost(ResultSet rs) {

        Post post = null;

        try {
            String user_id = rs.getString("user_id");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String image = rs.getString("image");
            String date = rs.getString("created_at");
            post = new Post(user_id,title,text,image,date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public static User getDataUser(ResultSet rs) {

        User user = null;

        try {
            String name = rs.getString("name");
            String email = rs.getString("email");
            user = new User(name,email,null);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }





}
