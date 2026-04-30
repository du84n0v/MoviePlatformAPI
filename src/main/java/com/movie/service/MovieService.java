package com.movie.service;

import com.movie.dto.Movie;
import com.movie.exeption.MovieNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;

@Getter

@Service
public class MovieService {
    private final List<Movie> movies = new ArrayList<>();

    public Movie createMovie(Movie movie) {
        movie.setId();
        movie.setRating(0D);
        movies.add(movie);
        return movie;
    }

    public Movie getMovieById(Integer movieId) {
        for (Movie movie : movies) {
            if(movie.getId().equals(movieId)) return movie;
        }
        throw new MovieNotFoundException("Movie not found");
    }

    public Boolean deleteMovieById(Integer movieId) {
        for (Movie movie : movies) {
            if(movie.getId().equals(movieId)){
                movies.remove(movie);
                return true;
            }
        }
        throw new MovieNotFoundException("Movie not found");
    }


    public List<Movie> searchMovie(String request) {
        return movies.stream()
                .filter(movie ->
                        movie.getTitle().contains(request) ||
                                movie.getGenre().contains(request) ||
                                movie.getReleaseYear().contains(request)
                ).toList();
    }

    public void updateMovieRatingById(@NotNull Integer movieId, double newRating) {
        for (Movie movie : movies) {
            if(movie.getId().equals(movieId)){
                movie.setRating(newRating);
                return;
            }
        }
        throw new MovieNotFoundException("Movie not found");
    }

    public List<Movie> getTop5Movies() {
        List<Movie> result = new LinkedList<>();
        Collections.sort(movies);
        for(int i = 0; i < Math.max(movies.size(), 5); ++ i){
            result.add(movies.get(i));
        }
        return result;
    }

    public Long getUserMovieNumber(Integer userId) {
        return movies.stream()
                .filter(movie -> movie.getCreatedBy().equals(userId))
                .count();
    }
}
