package com.pilatesappointment.ws.enumeration;

public enum ResponseMessages {
    USER_CREATED("User is created successfully."),
    USER_CREATION_FAILED("Failed to create user."),
    APPOINTMENT_CREATED("Appointment is created successfully."),
    APPOINTMENT_CREATION_FAILED("Failed to create appointment."),
    TRAINER_CREATED("Trainer is created successfully."),
    TRAINER_CREATION_FAILED("Failed to create trainer.");

    private final String message;

    ResponseMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
