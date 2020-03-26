package br.com.dev.simples.patients.dto.report;

import static br.com.dev.simples.patients.model.enumeration.AppointmentType.CHECKUP;
import static br.com.dev.simples.patients.model.enumeration.AppointmentType.CONSULTATION;
import static br.com.dev.simples.patients.model.enumeration.AppointmentType.EXAMINATION;
import static br.com.dev.simples.patients.model.enumeration.AppointmentType.MEDICAL_PROCEDURE;
import static br.com.dev.simples.patients.model.enumeration.AppointmentType.ROUTINE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.model.enumeration.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ReportPerPatient {
	
	private List<ReportWeekDTO> weeks;
	
	public ReportPerPatient() {
		weeks = new ArrayList<ReportWeekDTO>();
	}

	public void createWeek(int weekOfYear, List<Appointment> appointments)
	{
		ReportWeekDTO week = new ReportWeekDTO();
		
		week.setNumberOfAppointments(appointments.size());
		week.setWeekOfYear(weekOfYear);
		
		week.setCountPerType(CHECKUP, countAppointmentType(appointments, CHECKUP));
		week.setCountPerType(CONSULTATION, countAppointmentType(appointments, CONSULTATION));
		week.setCountPerType(EXAMINATION, countAppointmentType(appointments, EXAMINATION));
		week.setCountPerType(MEDICAL_PROCEDURE, countAppointmentType(appointments, MEDICAL_PROCEDURE));
		week.setCountPerType(ROUTINE, countAppointmentType(appointments, ROUTINE));
		
		BigDecimal sumOutcome = appointments.stream()
				.map( a-> a.getGlicemia().add(a.getWaistCircumference()).add(a.getWeight()) )
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		BigDecimal averageOutcome = sumOutcome.divide(new BigDecimal(appointments.size()));
		
		
		week.setAverageOutcomes(averageOutcome);
				
	}
	
	private Long countAppointmentType(List<Appointment> appointments, AppointmentType type) {
		return appointments.stream().filter(a->type.equals(a.getType())).collect(Collectors.counting());
	}

}
