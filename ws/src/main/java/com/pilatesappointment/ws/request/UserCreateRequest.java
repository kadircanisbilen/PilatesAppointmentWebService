package com.pilatesappointment.ws.request;

import com.pilatesappointment.ws.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank(message = "Name can not be blank.")
    @Size(min = 2, max = 50, message = "Name must has got at least 2 characters.")
    private String name;

    @NotBlank(message = "Surname can not be blank.")
    @Size(min = 2, max = 50, message = "Surname must has got at least 2 characters.")
    private String surname;

    @UniqueEmail
    @NotBlank(message = "Email can not be blank.")
    @Email(message = "Email must be well-formatted.")
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[A-Z])(?=.*[-\\#\\$\\.\\%\\&\\*])(?=.*[a-zA-Z]).{8,16}$",
            message = "Password must be minimum eight characters, at least one uppercase letter," +
                    " one lowercase letter, one number and one special character")
    private String password;
}
