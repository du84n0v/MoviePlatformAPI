package com.movie.controller;

import com.movie.dto.Movie;
import com.movie.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie){
        return ResponseEntity.ok(movieService.createMovie(movie));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getMovies(){
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/by-id/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable Integer movieId){
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<?> deleteMovieById(@PathVariable Integer movieId){
        return ResponseEntity.ok(movieService.deleteMovieById(movieId));
    }

    @GetMapping("/search/{request}")
    public ResponseEntity<?> searchMovie(@PathVariable String request){
        return ResponseEntity.ok(movieService.searchMovie(request));
    }

    @GetMapping("/top")
    public ResponseEntity<?> top5Movies(){
        return ResponseEntity.ok(movieService.getTop5Movies());
    }


}
