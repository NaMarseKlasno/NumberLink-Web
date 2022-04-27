package sk.tuke.gamestudio.service;

import java.util.List;

import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@Transactional
public class CommentJPA implements CommentService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getCommentsList() {
        return entityManager.createQuery("select comment from Comment comment").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM comment").executeUpdate();
    }

    @Override
    public void deleteLastComment() {
        entityManager.createNativeQuery("DELETE FROM comment WHERE commentid = (SELECT commentid FROM comment ORDER BY commentid DESC LIMIT 1);").executeUpdate();
//        entityManager.createNativeQuery("DELETE FROM comment").executeUpdate();
    }


}

