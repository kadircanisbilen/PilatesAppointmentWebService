package com.pilatesappointment.ws.request;

import com.pilatesappointment.ws.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank(message = "{pilates.constraint.name.NotBlank.message}")
    @Size(min = 2, max = 50, message = "{pilates.constraint.name.Size.message}")
    private String name;

    @NotBlank(message = "{pilates.constraint.surname.NotBlank.message}")
    @Size(min = 2, max = 50, message = "{pilates.constraint.surname.Size.message}")
    private String surname;

    @UniqueEmail(message = "{pilates.constraint.email.NotUnique.message}")
    @NotBlank(message = "{pilates.constraint.email.NotBlank.message}")
    @Email(message = "{pilates.constraint.email.Format.message}")
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[A-Z])(?=.*[-\\#\\$\\.\\%\\&\\*])(?=.*[a-zA-Z]).{8,16}$",
            message = "{pilates.constraint.passwordRegex.message}")
    private String password;
}
