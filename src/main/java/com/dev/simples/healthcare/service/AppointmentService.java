package com.dev.simples.healthcare.service;

import com.dev.simples.healthcare.dto.AppointmentDTO;
import com.dev.simples.healthcare.model.Appointment;
import com.dev.simples.healthcare.repository.AppointmentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ModelMapper mapper;


    public void saveAppointment(AppointmentDTO appointmentDTO) {
        appointmentRepository.save(mapper.map(appointmentDTO, Appointment.class));
    }

    public List<AppointmentDTO> getAppointments() {
        return appointmentRepository
                .findAll()
                .stream()
                .map(m -> mapper.map(m, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

}
