package com.pilatesappointment.ws.service.impl;

import com.pilatesappointment.ws.mapper.UserMapper;
import com.pilatesappointment.ws.model.Users;
import com.pilatesappointment.ws.repository.UserRepository;
import com.pilatesappointment.ws.request.UserCreateRequest;
import com.pilatesappointment.ws.service.IUserService;
import com.pilatesappointment.ws.util.GenericMessage;
import com.pilatesappointment.ws.util.Messages;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

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
        userRepository.save(user);
        sendActivationMail(user);
        String message = Messages.getMessageForLocale("pilates.constraint.userCreated", LocaleContextHolder.getLocale());
        return ResponseEntity.ok(new GenericMessage(message));
    }

    private void sendActivationMail(Users users) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("info@pilatesappointment.com");
        simpleMailMessage.setTo(users.getEmail());
        simpleMailMessage.setSubject("Account Activation");
        simpleMailMessage.setText("http://localhost:5173/activation/" +users.getActivationToken());
        getJavaMailSender().send(simpleMailMessage);

    }

    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.ethereal.email");
        mailSender.setPort(587);
        mailSender.setUsername("bret40@ethereal.email");
        mailSender.setPassword("tVQxCk3Ky3ahHcmdn8");

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", true);
        return mailSender;
    }
}
