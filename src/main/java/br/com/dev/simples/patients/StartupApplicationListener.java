package br.com.dev.simples.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.dev.simples.patients.model.Patient;
import br.com.dev.simples.patients.repository.PatientRepository;

@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		patientRepository.save(Patient.builder().id("marcos").firstName("Marcos Agostta").build());
		patientRepository.save(Patient.builder().id("simone").firstName("Simone Gianni").build());
	}

}
