package helpMetods;

import cards.Post;
import cards.User;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpMethods {

    public static Post getDataPost(ResultSet rs) {

        Post post = null;

        try {
            String id = String.valueOf(rs.getInt("id"));
            String user_id = rs.getString("user_id");
            String title = rs.getString("title");
            String text = rs.getString("text");
            String image = rs.getString("image");
            String date = rs.getString("created_at");
            post = new Post(id,user_id,title,text,image,date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public static User getDataUser(ResultSet rs) {

        User user = null;

        try {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            user = new User(id, name,email,null);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public static String downloadPhoto(Part filePart) throws IOException {

        String filename = filePart.getInputStream().toString();
        InputStream fileContent = filePart.getInputStream();
        File file1 =new File("C:\\Users\\egoeu.DESKTOP-3LRV9QH\\IdeaProjects\\semestral_work\\out\\artifacts\\semestral_work_war_exploded\\public\\"+filename+"."+"png");
        BufferedImage imBuff = ImageIO.read(fileContent);
        ImageIO.write(imBuff, "png", file1);
        return filename;
    }

    public static Timestamp getTimestampFromString(String paDate) {
        java.sql.Timestamp timeStampDate = null;

        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = formatter.parse(paDate);
            timeStampDate = new Timestamp(date.getTime());

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }
        return timeStampDate;
    }







}
