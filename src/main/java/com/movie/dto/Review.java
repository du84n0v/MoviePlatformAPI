package com.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Review {
    private static Integer counter = 0;
    private Integer id;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer movieId;
    private Integer rating;
    @NotBlank(message = "Comment should be something")
    private String comment;

    public void setId(){
        this.id = counter ++;
    }
}
