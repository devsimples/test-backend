package br.com.dev.simples.patients.mapping;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.model.Patient;

@Component
public class AppointmentMapping {

	public final Function<Appointment, AppointmentDTO>  toDTO = (Appointment appointment) -> 
		AppointmentDTO.builder()
			.localDateTime(appointment.getLocalDateTime())
			.patientId( appointment.getPatient().getId() )
			.type(appointment.getType())
			.glicemia(appointment.getGlicemia())
			.weight(appointment.getWeight())
			.waistCircumference(appointment.getWaistCircumference())
			.build();
		
	public final Function<AppointmentDTO, Appointment>  toAppointment = (AppointmentDTO dto) -> 
		Appointment.builder()
			.localDateTime(dto.getLocalDateTime())
			.patient( Patient.builder().id(dto.getPatientId()).build() )
			.type(dto.getType())
			.glicemia(dto.getGlicemia())
			.weight(dto.getWeight())
			.waistCircumference(dto.getWaistCircumference())
			.build();
}
