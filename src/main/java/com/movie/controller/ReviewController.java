package com.movie.controller;

import com.movie.dto.Review;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    public static List<Review> reviews = new ArrayList<>();

    @PostMapping("/create")
    public Review createReview(@RequestBody Review review){
        for (Review review1 : reviews) {
            if(review1.getMovieId() == review.getId() && review1.getUserId() == review.getUserId()) return null;
        }
        review.setId();
        reviews.add(review);
        return review;
    }

    @GetMapping("/by-movie-id/{movieId}")
    public List<Review> getMovieReviews(@PathVariable Integer movieId){
        List<Review> response = new ArrayList<>();
        for (Review review : reviews) {
            if(review.getMovieId() == movieId) response.add(review);
        }
        return response;
    }


}
