package com.movie.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Movie {
    private static Integer counter = 0;
    private Integer id;
    @NotBlank(message = "title should not be empty")
    private String title;
    @NotBlank(message = "Genre should be empty")
    private String genre;
    private String releaseYear;
    private Double rating;
    @NotNull
    private Integer createdBy;

    public void setId(){
        this.id = counter ++;
    }

}
