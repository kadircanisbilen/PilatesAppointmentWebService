package com.pilatesappointment.ws.controller;

import com.pilatesappointment.ws.request.TrainerCreateRequest;
import com.pilatesappointment.ws.response.TrainerCreateResponse;
import com.pilatesappointment.ws.service.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {

    private final ITrainerService trainerService;

    @Autowired
    public TrainerController(ITrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("api/v1/trainer")
    ResponseEntity<TrainerCreateResponse> createTrainer (@RequestBody TrainerCreateRequest request){
        TrainerCreateResponse response = trainerService.createTrainer(request);
        return ResponseEntity.ok(response);
    }
}
