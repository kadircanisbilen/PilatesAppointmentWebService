package com.pilatesappointment.ws.service;

import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.response.UserCreateResponse;

public interface IUserService {
    UserCreateResponse createUser (UserCreateRequest request);
}
