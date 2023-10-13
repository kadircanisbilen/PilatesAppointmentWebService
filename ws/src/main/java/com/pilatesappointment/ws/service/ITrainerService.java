package com.pilatesappointment.ws.service;

import com.pilatesappointment.ws.request.TrainerCreateRequest;
import com.pilatesappointment.ws.response.TrainerCreateResponse;

public interface ITrainerService {

    TrainerCreateResponse createTrainer (TrainerCreateRequest request);
}
