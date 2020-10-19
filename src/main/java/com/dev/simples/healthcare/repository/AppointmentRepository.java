package com.dev.simples.healthcare.repository;

import com.dev.simples.healthcare.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    @Override
    List<Appointment> findAll();

    List<Appointment> findByPatientId(String id);

    @Query("from Appointment a where a.patient.id = ?1")
    List<Appointment> findByPatientIdUsingHQL(String id);

}
