package com.pilatesappointment.ws.service.impl;

import com.pilatesappointment.ws.mapper.TrainerMapper;
import com.pilatesappointment.ws.model.Trainer;
import com.pilatesappointment.ws.repository.TrainerRepository;
import com.pilatesappointment.ws.request.TrainerCreateRequest;
import com.pilatesappointment.ws.response.TrainerCreateResponse;
import com.pilatesappointment.ws.service.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrainerServiceImpl implements ITrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository, TrainerMapper trainerMapper) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
    }

    @Override
    public TrainerCreateResponse createTrainer(TrainerCreateRequest request) {
        Trainer trainer = trainerMapper.trainerCreateRequestToTrainer(request);
        trainer.setCreatedAt(LocalDate.now());
        trainer.setUpdatedAt(LocalDate.now());
        trainerRepository.save(trainer);
        return trainerMapper.trainerToTrainerCreateResponse(trainer);
    }
}
