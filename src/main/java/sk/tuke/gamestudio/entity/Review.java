package sk.tuke.gamestudio.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;

    private String content;
    private Long userID;
    private String commentedAt;
    private Integer rating;


    public Review(Long userID, String content, Integer rating) {
        this.userID = userID;
        this.content = content;
        this.rating = rating;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, h:mm a", Locale.ENGLISH);
        this.commentedAt = myDateObj.format(myFormatObj);
    }

    public Review() {}



    public Long getUserID() {
        return userID;
    }

    public String getComment() {
        return content;
    }

    public String  getReviewedAt() {
        return commentedAt;
    }

    public Integer getRating() {
        return rating;
    }

    public String getCommentedAt() {
        return commentedAt;
    }
}
