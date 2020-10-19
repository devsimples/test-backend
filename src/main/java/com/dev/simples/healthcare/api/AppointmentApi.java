package com.dev.simples.healthcare.api;

import com.dev.simples.healthcare.dto.AppointmentDTO;
import com.dev.simples.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
@CrossOrigin(origins = "localho", allowedHeaders = "*")
public class AppointmentApi {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public void createAppointment(@RequestBody AppointmentDTO appointment) {
        appointmentService.saveAppointment(appointment);
    }

    @GetMapping
    public List<AppointmentDTO> getAppointments() {
        return appointmentService.getAppointments();
    }

}
