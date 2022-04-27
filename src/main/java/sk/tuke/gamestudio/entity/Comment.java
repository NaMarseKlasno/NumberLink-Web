package sk.tuke.gamestudio.entity;

import javax.persistence.*;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    private String content;
    private Long userID;


    public Comment(Long id, String content) {
        this.userID = id;
        this.content = content;
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
}
