package br.com.dev.simples.patients.mapping;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.model.Appointment;

@Component
public class AppointmentMappting {

	public final Function<Appointment, AppointmentDTO>  toDTO = (Appointment appointment) -> 
		AppointmentDTO.builder().build();
		
	public final Function<AppointmentDTO, Appointment>  toAppointment = (AppointmentDTO dto) -> 
		Appointment.builder().build();
}
