package com.pilatesappointment.ws.controller;

import com.pilatesappointment.ws.enumeration.ValidationMessages;
import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.service.IUserService;
import error.ApiError;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class UserController {

    private final IUserService userService;

    private static final String PATH = "/api/v1/users";
    private static final int BAD_REQUEST_STATUS = 400;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/users")
    ResponseEntity<?> createUser(@Valid @RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidEx(MethodArgumentNotValidException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath(PATH);
        apiError.setMessage(ValidationMessages.VALIDATION_ERROR.getMessage());
        apiError.setStatus(BAD_REQUEST_STATUS);
//        Map<String, String> validationErrors = new HashMap<>();
//        for (var fieldError: exception.getBindingResult().getFieldErrors()){
//            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
        var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(
                FieldError::getField, FieldError::getDefaultMessage, (existing, replacing) -> existing));
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }
}
