package com.pilatesappointment.ws.controller;

import com.pilatesappointment.ws.request.AppointmentCreateRequest;
import com.pilatesappointment.ws.response.AppointmentCreateResponse;
import com.pilatesappointment.ws.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @Autowired
    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("api/v1/appointment")
    ResponseEntity<AppointmentCreateResponse> createAppointment (@RequestBody AppointmentCreateRequest request){
        AppointmentCreateResponse response = appointmentService.createAppointment(request);
        return ResponseEntity.ok(response);
    }
}
