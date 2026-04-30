package com.movie.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieRating {
    private Integer ratingCount;
    private Double ratingSum;
}
