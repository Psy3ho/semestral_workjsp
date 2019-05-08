package cards;

public class Post {
    private String id, userId, title, text, image, date;

    public Post(String id,String userId, String title, String text, String image, String date) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.image = image;
        this.date = date;
    }

    public String getId(){return  id;}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {return date; }

    public void setDate(String date) { this.date = date; }
}
