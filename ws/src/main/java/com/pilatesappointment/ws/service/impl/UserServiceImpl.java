package com.pilatesappointment.ws.service.impl;

import com.pilatesappointment.ws.mapper.UserMapper;
import com.pilatesappointment.ws.model.Users;
import com.pilatesappointment.ws.repository.UserRepository;
import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.response.UserCreateResponse;
import com.pilatesappointment.ws.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserCreateResponse createUser(UserCreateRequest request) {
        if(request == null) {
            throw new IllegalArgumentException("Request cannot be null.");
        } else {
            Users user = userMapper.userCreateRequestToUser(request);
            userRepository.save(user);
            return userMapper.userCreateRequestToUserCreateResponse(request);
        }
    }
}
