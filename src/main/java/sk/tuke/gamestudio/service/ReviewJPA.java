package sk.tuke.gamestudio.service;

import java.util.List;

import sk.tuke.gamestudio.entity.Review;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@Transactional
public class ReviewJPA implements ReviewService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addReview(Review review) {
        entityManager.persist(review);
    }

    @Override
    public List<Review> getReviewList() {
        return entityManager.createQuery("select review from Review review").getResultList();
    }

}

