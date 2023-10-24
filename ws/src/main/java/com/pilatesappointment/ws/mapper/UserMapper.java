package com.pilatesappointment.ws.mapper;

import com.pilatesappointment.ws.model.Users;
import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.response.UserCreateResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class UserMapper {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Users userCreateRequestToUsers(UserCreateRequest request) {
        if (request == null) {
            return null;
        }

        Users users = new Users();
        users.setActivationToken(UUID.randomUUID().toString());
        users.setName(request.getName());
        users.setSurname(request.getSurname());
        users.setEmail(request.getEmail());
        users.setCreatedAt(LocalDate.now());
        users.setUpdatedAt(LocalDate.now());
        users.setPassword(passwordEncoder.encode(request.getPassword()));

        return users;
    }

    public UserCreateResponse usersToUserCreateResponse(Users users) {
        if (users == null) {
            return null;
        }

        UserCreateResponse response = new UserCreateResponse();
        response.setName(users.getName());
        response.setSurname(users.getSurname());
        response.setEmail(users.getEmail());

        return response;
    }
}
