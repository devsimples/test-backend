package br.com.dev.simples.patients.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.mapping.AppointmentMappting;
import br.com.dev.simples.patients.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private AppointmentMappting mapping;
	
	
	public void saveAppointment(AppointmentDTO appointmentDTO) {
		appointmentRepository.save( mapping.toAppointment.apply(appointmentDTO) );
	}
	
	public List<AppointmentDTO> getAppointments(){
		return appointmentRepository
				.findAll()
				.stream()
				.map(mapping.toDTO)
				.collect(Collectors.toList());
	}
	
}
