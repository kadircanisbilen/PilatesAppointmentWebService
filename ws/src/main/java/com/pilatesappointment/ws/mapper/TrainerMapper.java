package com.pilatesappointment.ws.mapper;

import com.pilatesappointment.ws.model.Trainer;
import com.pilatesappointment.ws.request.TrainerCreateRequest;
import com.pilatesappointment.ws.response.TrainerCreateResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TrainerMapper {

    public Trainer trainerCreateRequestToTrainer(TrainerCreateRequest request) {
        if (request == null) {
            return null;
        }

        Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setSurname(request.getSurname());
        trainer.setEmail(request.getEmail());
        trainer.setPassword(request.getPassword());

        trainer.setAppointments(new ArrayList<>());

        return trainer;
    }

    public TrainerCreateResponse trainerToTrainerCreateResponse(Trainer trainer) {
        if (trainer == null) {
            return null;
        }

        TrainerCreateResponse response = new TrainerCreateResponse();
        response.setName(trainer.getName());
        response.setSurname(trainer.getSurname());
        response.setEmail(trainer.getEmail());

        return response;
    }
}
