package br.com.dev.simples.patients.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.simples.patients.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

	@Override
    public List<Appointment> findAll();
	
}
