package sk.tuke.gamestudio.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Person;
import sk.tuke.gamestudio.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentServiceRest {

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public List<Comment> getUsersList() {
        return commentService.getCommentsList();
    }

    @PostMapping
    public void addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
    }
}
