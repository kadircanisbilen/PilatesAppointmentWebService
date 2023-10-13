package com.pilatesappointment.ws.service;

import com.pilatesappointment.ws.request.UserCreateRequest;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    @Transactional
    ResponseEntity<?> createUser(UserCreateRequest request);
}
