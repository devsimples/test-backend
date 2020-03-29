package br.com.dev.simples.patients.repository;

import br.com.dev.simples.patients.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

	@Override
    public List<Appointment> findAll();

    public List<Appointment> findByPatientId(String id);

}
