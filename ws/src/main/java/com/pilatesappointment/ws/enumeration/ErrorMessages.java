package com.pilatesappointment.ws.enumeration;

public enum ErrorMessages {
    USER_NOT_FOUND("User doesn't exist with id: "),
    TRAINER_NOT_FOUND("Trainer doesn't exist with id: ");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
