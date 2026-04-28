package com.movie.dto;

import com.movie.enums.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private static Integer counter = 0;
    private Integer id;
    private String fullName;
    private String email;
    private Roles role;

    public User(){
        this.id = counter ++;
    }
}
