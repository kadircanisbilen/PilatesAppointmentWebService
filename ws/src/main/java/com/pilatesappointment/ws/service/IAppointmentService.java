package com.pilatesappointment.ws.service;

import com.pilatesappointment.ws.request.AppointmentCreateRequest;
import com.pilatesappointment.ws.response.AppointmentCreateResponse;

public interface IAppointmentService {

    AppointmentCreateResponse createAppointment (AppointmentCreateRequest request);
}
