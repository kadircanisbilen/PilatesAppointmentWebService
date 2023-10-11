package com.pilatesappointment.ws.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
}
