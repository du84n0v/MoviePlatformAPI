package com.movie.dto;

import com.movie.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter

public class User {
    private static Integer counter = 0;
    private Integer id;
    @NotBlank(message = "Fullname should not be empty")
    @Size(min = 3, max = 30, message = "fullname size should be min 3 and max 30")
    private String fullName;
    @Email
    private String email;
    private Roles role;

    public void setId(){
        this.id = counter ++;
    }
}
