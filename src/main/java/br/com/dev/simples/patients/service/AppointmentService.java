package br.com.dev.simples.patients.service;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.mapping.AppointmentMapping;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

}
