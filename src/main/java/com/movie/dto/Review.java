package com.movie.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(value = 1, message = "Rating should bot be less then 1")
    @Max(value = 5, message = "Rating should not be more then 5")
    private Double rating;
    @NotBlank(message = "Comment should be something")
    private String comment;

    public void setId(){
        this.id = counter ++;
    }
}
