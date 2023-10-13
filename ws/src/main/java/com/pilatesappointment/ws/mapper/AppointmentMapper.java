package com.pilatesappointment.ws.mapper;

import com.pilatesappointment.ws.enumeration.ErrorMessages;
import com.pilatesappointment.ws.model.Appointment;
import com.pilatesappointment.ws.model.Trainer;
import com.pilatesappointment.ws.model.Users;
import com.pilatesappointment.ws.repository.TrainerRepository;
import com.pilatesappointment.ws.repository.UserRepository;
import com.pilatesappointment.ws.request.AppointmentCreateRequest;
import com.pilatesappointment.ws.response.AppointmentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Optional;

@Component
public class AppointmentMapper {

    private final UserRepository userRepository;
    private final TrainerRepository trainerRepository;

    @Autowired
    public AppointmentMapper(UserRepository userRepository, TrainerRepository trainerRepository) {
        this.userRepository = userRepository;
        this.trainerRepository = trainerRepository;
    }

    public Appointment appointmentCreateRequestToAppointment(AppointmentCreateRequest request) {
        if (request == null) {
            return null;
        }

        Appointment appointment = new Appointment();
        appointment.setDate(request.getDate());
        appointment.setTime(LocalTime.parse(request.getTime()));
        appointment.setNotes(request.getNotes());

        Optional<Users> user = Optional.of(userRepository.findById(
                request.getUserId()).orElseThrow(() -> new RuntimeException(
                        ErrorMessages.USER_NOT_FOUND.getMessage() + request.getUserId())));
        appointment.setUser(user.get());

        Optional<Trainer> trainer = Optional.of(trainerRepository.findById(
                request.getTrainerId())).orElseThrow(() -> new RuntimeException(
                        ErrorMessages.TRAINER_NOT_FOUND.getMessage()+request.getTrainerId()));
        appointment.setTrainer(trainer.get());

        return appointment;
    }

    public AppointmentCreateResponse appointmentToAppointmentCreateResponse(Appointment appointment) {
        if (appointment == null) {
            return null;
        }

        AppointmentCreateResponse response = new AppointmentCreateResponse();
        response.setAppointmentId(appointment.getId());
        response.setUserId(appointment.getUser().getId());
        response.setUserFullName(appointment.getUser().getName() + " " + appointment.getUser().getSurname());
        response.setTrainerId(appointment.getTrainer().getId());
        response.setTrainerFullName(appointment.getTrainer().getName() + " " + appointment.getTrainer().getSurname());
        response.setDate(appointment.getDate());
        response.setTime(appointment.getTime().toString());
        response.setNotes(appointment.getNotes());

        return response;
    }
}
