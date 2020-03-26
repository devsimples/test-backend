package br.com.dev.simples.patients;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import br.com.dev.simples.patients.dto.report.ReportPerPatient;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.model.enumeration.AppointmentType;

public class ReportTest {
	
	@Test
	//Only for test purpose, delete this class
	public void test()
	{
		Appointment a1 = Appointment.builder().localDateTime(LocalDateTime.now())
				.glicemia(BigDecimal.valueOf(1))
				.weight(BigDecimal.valueOf(1)).type(AppointmentType.CHECKUP).build();
		
		Appointment a2 = Appointment.builder().localDateTime(LocalDateTime.now())
				.glicemia(BigDecimal.valueOf(1))
				.weight(BigDecimal.valueOf(1)).type(AppointmentType.CONSULTATION).build();
		
		Appointment a3 = Appointment.builder().localDateTime(LocalDateTime.now().minusMonths(1))
				.glicemia(BigDecimal.valueOf(1))
				.weight(BigDecimal.valueOf(9)).type(AppointmentType.ROUTINE).build();
		
		
		ReportPerPatient report = new ReportPerPatient();
		Map<Integer, List<Appointment>> groupedByWeek = Arrays.asList(a1, a2, a3)
				.stream()
				.collect(Collectors.groupingBy(Appointment::getWeekOfYear));
		
		groupedByWeek.keySet().forEach(week -> report.createWeek(week, groupedByWeek.get(week)));
		

		
		System.out.println(groupedByWeek);
		
	}
	
    
}
