package com.pilatesappointment.ws.enumeration;

public enum ValidationMessages {
    VALIDATION_ERROR("Validation error."),
    USER_NAME_REQUIRED("User name is required."),
    USER_EMAIL_REQUIRED("User email is required."),
    USER_EMAIL_INVALID("Invalid email address for user."),
    USER_PASSWORD_REQUIRED("User password is required."),

    TRAINER_NAME_REQUIRED("Trainer name is required."),
    TRAINER_EMAIL_REQUIRED("Trainer email is required."),
    TRAINER_EMAIL_INVALID("Invalid email address for trainer."),
    TRAINER_PASSWORD_REQUIRED("Trainer password is required."),

    APPOINTMENT_DATE_REQUIRED("Appointment date is required."),
    APPOINTMENT_TIME_REQUIRED("Appointment time is required."),
    APPOINTMENT_USER_REQUIRED("User ID is required for appointment."),
    APPOINTMENT_TRAINER_REQUIRED("Trainer ID is required for appointment.");

    private final String message;

    ValidationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
