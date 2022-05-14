package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Review;

import java.util.List;

public interface ReviewService {

    void addReview(Review review);
    List<Review> getReviewList();
}
