package br.com.dev.simples.patients.mapping;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.dev.simples.patients.dto.PatientDTO;
import br.com.dev.simples.patients.model.Patient;

@Component
public class PatientMappting {

	public final Function<Patient, PatientDTO>  toDTO = (Patient patient) -> 
		PatientDTO.builder()
			.id(patient.getId())
			.firstName(patient.getFirstName())
			.build();
		
	public final Function<PatientDTO, Patient>  toPatient = (PatientDTO dto) -> 
		Patient.builder()
			.id(dto.getId())
			.firstName(dto.getFirstName())
			.build();
}
