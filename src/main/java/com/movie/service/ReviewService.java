package com.movie.service;

import com.movie.dto.Review;
import com.movie.exeption.DuplicateReviewException;
import com.movie.util.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {
    private static final List<Review> reviews = new ArrayList<>();
    @Autowired
    private MovieService movieService;

    private final Map<Integer, MovieRating> movieRating = new HashMap<>();

    public Review createReview(Review newReview) {
        for (Review review : reviews) {
            if(review.getUserId().equals(newReview.getUserId()) && review.getMovieId().equals(newReview.getMovieId())){
                throw new DuplicateReviewException("User's commented this movie before");
            }
        }
        newReview.setId();
        reviews.add(newReview);
        if(!movieRating.containsKey(newReview.getMovieId())){
            movieRating.put(newReview.getMovieId(), new MovieRating(0, 0D));
        }
        int newRatingCount = movieRating.get(newReview.getMovieId()).getRatingCount() + 1;
        double newRatingSum = movieRating.get(newReview.getMovieId()).getRatingSum() + newReview.getRating();
        movieService.updateMovieRatingById(newReview.getMovieId(), newRatingSum / (1D*newRatingCount));
        movieRating.get(newReview.getMovieId()).setRatingCount(newRatingCount);
        movieRating.get(newReview.getMovieId()).setRatingSum(newRatingSum);
        return newReview;
    }

    public List<Review> getMovieCommentsByMovieId(Integer movieId) {
        return reviews.stream()
                .filter(review -> review.getMovieId().equals(movieId))
                .toList();
    }

    public Long getUserReviewNumber(Integer userId) {
        return reviews.stream()
                .filter(review -> review.getUserId().equals(userId))
                .count();
    }
}
