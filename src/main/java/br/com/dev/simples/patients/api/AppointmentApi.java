package br.com.dev.simples.patients.api;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.dto.report.ReportPerPatient;
import br.com.dev.simples.patients.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	
	@GetMapping("/report/{patientId}")
	public ReportPerPatient getReportByPatient (@PathVariable String patientId) {
		return appointmentService.getReport(patientId);
	}

	
}
