package com.pilatesappointment.ws.response;

import lombok.Data;

@Data
public class UserCreateResponse {
    private String name;
    private String surname;
    private String email;
}
