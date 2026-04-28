package com.movie.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class Movie {
    private static Integer counter = 0;
    private Integer id;
    private String title;
    private String genre;
    private LocalDate releaseYear;
    private Double rating;
    private Integer createdBy;

    public Movie(){
        this.id = counter ++;

    }

}
