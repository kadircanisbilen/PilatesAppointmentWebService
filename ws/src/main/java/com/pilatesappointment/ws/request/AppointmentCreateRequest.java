package com.pilatesappointment.ws.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentCreateRequest {
    private Long userId;
    private Long trainerId;
    private LocalDate date;
    private String time;
    private String notes;
}
