package com.movie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Review {
    private static Integer counter = 0;
    private Integer id;
    private Integer userId;
    private Integer movieId;
    private Integer rating;
    private String comment;

    public void setId(){
        this.id = counter ++;
    }
}
