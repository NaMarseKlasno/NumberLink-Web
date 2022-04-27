package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Person;
import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getCommentsList();
    void reset();
    void deleteLastComment();
}


