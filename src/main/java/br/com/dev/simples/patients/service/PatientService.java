package br.com.dev.simples.patients.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.simples.patients.dto.PatientDTO;
import br.com.dev.simples.patients.mapping.PatientMappting;
import br.com.dev.simples.patients.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientMappting mapping;

	public void savePatient(PatientDTO patientDTO) {
		patientRepository.save( mapping.toPatient.apply(patientDTO) );
	}
	
	public List<PatientDTO> getPatients(){
		return patientRepository
				.findAll()
				.stream()
				.map(mapping.toDTO)
				.collect(Collectors.toList());
	}
	
}
