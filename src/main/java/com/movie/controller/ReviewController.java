package com.movie.controller;

import com.movie.dto.Review;
import com.movie.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@Valid @RequestBody Review review){
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping("/by-movie-id/{movieId}")
    public ResponseEntity<?> getMovieReviews(@PathVariable Integer movieId){
        return ResponseEntity.ok(reviewService.getMovieCommentsByMovieId(movieId));
    }


}
