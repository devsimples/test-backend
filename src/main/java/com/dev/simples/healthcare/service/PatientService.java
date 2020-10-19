package com.dev.simples.healthcare.service;

import com.dev.simples.healthcare.model.Patient;
import com.dev.simples.healthcare.repository.PatientRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.simples.healthcare.dto.PatientDTO;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper mapper;

    public void createPatient(PatientDTO patientDTO) {
        patientDTO.setId(UUID.randomUUID().toString());
        patientRepository.save(mapper.map(patientDTO, Patient.class));
    }

    public List<PatientDTO> getPatients() {
        return patientRepository
                .findAll()
                .stream()
                .map(p -> mapper.map(p, PatientDTO.class))
                .collect(Collectors.toList());
    }

}
