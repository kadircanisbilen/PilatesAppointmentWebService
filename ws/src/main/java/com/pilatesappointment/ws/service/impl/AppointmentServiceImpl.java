package com.pilatesappointment.ws.service.impl;

import com.pilatesappointment.ws.mapper.AppointmentMapper;
import com.pilatesappointment.ws.model.Appointment;
import com.pilatesappointment.ws.repository.AppointmentRepository;
import com.pilatesappointment.ws.request.AppointmentCreateRequest;
import com.pilatesappointment.ws.response.AppointmentCreateResponse;
import com.pilatesappointment.ws.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentCreateResponse createAppointment(AppointmentCreateRequest request) {
        Appointment appointment = appointmentMapper.appointmentCreateRequestToAppointment(request);
        appointment.setCreatedAt(LocalDate.now());
        appointment.setUpdatedAt(LocalDate.now());
        appointmentRepository.save(appointment);
        return appointmentMapper.appointmentToAppointmentCreateResponse(appointment);
    }
}
