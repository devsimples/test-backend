package br.com.dev.simples.patients;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.repository.AppointmentRepository;
import br.com.dev.simples.patients.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.dev.simples.patients.model.Patient;
import br.com.dev.simples.patients.repository.PatientRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static br.com.dev.simples.patients.model.enumeration.AppointmentType.MEDICAL_PROCEDURE;

@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		patientRepository.save(Patient.builder().id("marcos").firstName("Marcos").lastName("Agostta").build());
		patientRepository.save(Patient.builder().id("simone").firstName("Simone").lastName("Gianni").build());

		appointmentRepository.save(Appointment.builder().localDateTime(LocalDateTime.of(2020, 1, 5, 12, 0))
				.glicemia(BigDecimal.valueOf(1))
				.weight(BigDecimal.valueOf(1))
				.waistCircumference(BigDecimal.valueOf(1))
				.patient(Patient.builder().id("marcos").build())
				.type(MEDICAL_PROCEDURE).build());

		appointmentRepository.save(Appointment.builder().localDateTime(LocalDateTime.of(2019, 2, 5, 12, 0))
				.glicemia(BigDecimal.valueOf(5))
				.weight(BigDecimal.valueOf(4))
				.waistCircumference(BigDecimal.valueOf(2))
				.patient(Patient.builder().id("marcos").build())
				.type(MEDICAL_PROCEDURE).build());

		appointmentRepository.save(Appointment.builder().localDateTime(LocalDateTime.of(2019, 2, 5, 17, 0))
				.glicemia(BigDecimal.valueOf(5))
				.weight(BigDecimal.valueOf(4))
				.waistCircumference(BigDecimal.valueOf(2))
				.patient(Patient.builder().id("marcos").build())
				.type(MEDICAL_PROCEDURE).build());
	}

}
