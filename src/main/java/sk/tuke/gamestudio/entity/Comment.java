package sk.tuke.gamestudio.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    private String content;
    private Long userID;
    private String commentedAt;




    public Comment(Long id, String content) {
        this.userID = id;
        this.content = content;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, h:mm a", Locale.ENGLISH);
        this.commentedAt = myDateObj.format(myFormatObj);
    }

    public Comment() {

    }

    public Long getUserID() {
        return userID;
    }

    public String getComment() {
        return content;
    }


    public void setCommentID(Long id) {
        this.commentID = id;
    }

    public long getCommentID() {
        return commentID;
    }

    public String  getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(String commentedAt) {
        this.commentedAt = commentedAt;
    }

}
