package com.movie.service;

import com.movie.dto.Review;
import com.movie.exeption.DuplicateReviewException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    public static List<Review> reviews = new ArrayList<>();

    public Review createReview(Review newReview) {
        for (Review review : reviews) {
            if(review.getUserId().equals(newReview.getUserId()) && review.getMovieId().equals(newReview.getMovieId())){
                throw new DuplicateReviewException("User's commented this movie before");
            }
        }
        newReview.setId();
        reviews.add(newReview);
        return newReview;
    }

    public List<Review> getMovieCommentsByMovieId(Integer movieId) {
        return reviews.stream()
                .filter(review -> review.getMovieId().equals(movieId))
                .toList();
    }
}
