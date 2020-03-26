package br.com.dev.simples.patients.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.dto.report.ReportPerPatient;
import br.com.dev.simples.patients.mapping.AppointmentMapping;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.model.enumeration.AppointmentType;
import br.com.dev.simples.patients.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private AppointmentMapping mapping;
	
	
	public void saveAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = mapping.toAppointment.apply(appointmentDTO);
		appointmentRepository.save( appointment );
	}
	
	public List<AppointmentDTO> getAppointments(){
		return appointmentRepository
				.findAll()
				.stream()
				.map(mapping.toDTO)
				.collect(Collectors.toList());
	}
	
	
	public List<ReportPerPatient> getReport(){
		List<Appointment> appointments = appointmentRepository.findByPatientId("marcos");
		
		
		
		return null;
	}

	public void test(){
		saveAppointment(AppointmentDTO
				.builder()
				.localDateTime(LocalDateTime.now())
				.patientId("marcos")
				.type(AppointmentType.MEDICAL_PROCEDURE).build());
		saveAppointment(AppointmentDTO
				.builder()
				.localDateTime(LocalDateTime.now())
				.patientId("marcos")
				.type(AppointmentType.MEDICAL_PROCEDURE).build());
		saveAppointment(AppointmentDTO
				.builder()
				.localDateTime(LocalDateTime.now())
				.patientId("marcos")
				.type(AppointmentType.CHECKUP).build());
		
		
		System.out.println(getReport());
	}
	
}
