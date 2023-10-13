package com.pilatesappointment.ws.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentCreateResponse {
    private Long appointmentId;
    private Long userId;
    private String userFullName;
    private Long trainerId;
    private String trainerFullName;
    private LocalDate date;
    private String time;
    private String notes;
}
