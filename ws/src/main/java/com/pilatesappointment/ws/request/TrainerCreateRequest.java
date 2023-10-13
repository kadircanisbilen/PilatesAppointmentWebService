package com.pilatesappointment.ws.request;

import lombok.Data;

@Data
public class TrainerCreateRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
}
