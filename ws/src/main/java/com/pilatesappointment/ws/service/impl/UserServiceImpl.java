package com.pilatesappointment.ws.service.impl;

import com.pilatesappointment.ws.enumeration.ResponseMessages;
import com.pilatesappointment.ws.mapper.UserMapper;
import com.pilatesappointment.ws.model.Users;
import com.pilatesappointment.ws.repository.UserRepository;
import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.service.IUserService;
import com.pilatesappointment.ws.util.GenericMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    public ResponseEntity<?> createUser(UserCreateRequest request) {
        Users user = userMapper.userCreateRequestToUsers(request);
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());
        userRepository.save(user);
        return ResponseEntity.ok(new GenericMessage(ResponseMessages.USER_CREATED.getMessage()));
    }
}
