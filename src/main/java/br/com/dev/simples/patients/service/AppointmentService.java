package br.com.dev.simples.patients.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.simples.patients.dto.AppointmentDTO;
import br.com.dev.simples.patients.dto.report.ReportPerPatient;
import br.com.dev.simples.patients.mapping.AppointmentMapping;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private AppointmentMapping mapping;
	
	
	public void saveAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = mapping.toAppointment.apply(appointmentDTO);
		appointmentRepository.save( appointment );
	}
	
	public List<AppointmentDTO> getAppointments(){
		return appointmentRepository
				.findAll()
				.stream()
				.map(mapping.toDTO)
				.collect(Collectors.toList());
	}

	public ReportPerPatient getReport(final String patientId){
		ReportPerPatient report = new ReportPerPatient();
		List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
		
		Map<Integer, List<Appointment>> groupedByYear = appointments.stream().collect(groupingBy(Appointment::getYear));
		
		for (Integer year : groupedByYear.keySet()) {
			
			Map<Integer, List<Appointment>> groupedByWeek = groupedByYear.get(year).stream()
					.collect(groupingBy(Appointment::getWeekOfYear));
			
			groupedByWeek.keySet().forEach(week -> report.createWeek(year, week, groupedByWeek.get(week)));
		}
		
		return report;
	}
	
}
