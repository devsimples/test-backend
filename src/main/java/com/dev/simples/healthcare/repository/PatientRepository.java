package com.dev.simples.healthcare.repository;

import com.dev.simples.healthcare.model.Patient;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {

    @Override
    List<Patient> findAll();

}
