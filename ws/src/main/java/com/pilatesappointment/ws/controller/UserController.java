package com.pilatesappointment.ws.controller;

import com.pilatesappointment.ws.mapper.UserMapper;

import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.response.UserCreateResponse;
import com.pilatesappointment.ws.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/users")
    UserCreateResponse createUser(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }
}
