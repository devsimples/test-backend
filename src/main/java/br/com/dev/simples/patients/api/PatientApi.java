package br.com.dev.simples.patients.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.simples.patients.dto.PatientDTO;
import br.com.dev.simples.patients.service.PatientService;

@RestController
@RequestMapping("patients")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientApi {

	@Autowired
	private PatientService patientService;

	@PostMapping
	public void createPatient(@RequestBody PatientDTO patient) {
		patientService.savePatient(patient);
	}
	
	@GetMapping
	public List<PatientDTO> getPatients() {
		return patientService.getPatients();
	}

}
