package com.movie.controller;

import com.movie.dto.Review;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    

    @PostMapping("/create")
    public Review createReview(@RequestBody Review review){
        review.setId();

    }

}
