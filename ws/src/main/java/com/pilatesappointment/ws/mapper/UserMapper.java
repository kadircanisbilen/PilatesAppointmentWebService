package com.pilatesappointment.ws.mapper;

import com.pilatesappointment.ws.model.Users;
import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.response.UserCreateResponse;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class UserMapper {
    public Users userCreateRequestToUser (UserCreateRequest request){
        Users user = new Users();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());
        return user;
    }

    public UserCreateResponse userCreateRequestToUserCreateResponse (UserCreateRequest request){
        UserCreateResponse userCreateResponse = new UserCreateResponse();
        userCreateResponse.setName(request.getName());
        userCreateResponse.setSurname(request.getSurname());
        userCreateResponse.setEmail(request.getEmail());
        return userCreateResponse;
    }
}
