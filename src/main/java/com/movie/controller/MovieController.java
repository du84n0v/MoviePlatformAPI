package com.movie.controller;

import com.movie.dto.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    List<Movie> movies = new ArrayList<>();

    @PostMapping("/create")
    public Movie createMovie(@RequestBody Movie movie){
        movie.setId();
        movies.add(movie);
        return movie;
    }

    @GetMapping("/list")
    public List<Movie> getMovies(){
        return movies;
    }

    @GetMapping("/by-id/{movieId}")
    public Movie getMovieById(@PathVariable Integer movieId){
        for (Movie movie : movies) {
            if(movie.getId() == movieId) return movie;
        }
        return null;
    }

    @DeleteMapping("/delete/{movieId}")
    public Boolean deleteMovieById(@PathVariable Integer movieId){
        return movies.removeIf(movie -> movie.getId() == movieId);
    }


}
