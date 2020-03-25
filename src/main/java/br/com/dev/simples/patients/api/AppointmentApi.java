package br.com.dev.simples.patients.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.service.AppointmentService;

@RestController
@RequestMapping("appointment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
