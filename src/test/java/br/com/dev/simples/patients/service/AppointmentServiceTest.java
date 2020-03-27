
package br.com.dev.simples.patients.service;

import br.com.dev.simples.patients.dto.report.ReportPerPatient;
import br.com.dev.simples.patients.model.Appointment;
import br.com.dev.simples.patients.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static br.com.dev.simples.patients.model.enumeration.AppointmentType.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
public class AppointmentServiceTest {

	@Mock
	private AppointmentRepository appointmentRepository;

	@InjectMocks
	private AppointmentService service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGenerateReportSuccess() {
		Mockito.when(appointmentRepository.findByPatientId("marcos")).thenReturn(generateAppointments());

		ReportPerPatient report = service.getReport("marcos");

		assertThat(report, notNullValue());
		assertThat(report.getWeeks().size(), comparesEqualTo(3));

		assertThat(report.getWeeks().get(0).getNumberOfAppointments(), comparesEqualTo(2));
		assertThat(report.getWeeks().get(0).getYear(), comparesEqualTo(2020));
		assertThat(report.getWeeks().get(0).getAverageOutcomes(), comparesEqualTo(new BigDecimal(6)));
		assertThat(report.getWeeks().get(0).getCountPerType().get(MEDICAL_PROCEDURE), comparesEqualTo(2L));
		assertThat(report.getWeeks().get(0).getCountPerType().get(CHECKUP), comparesEqualTo(0L));

		assertThat(report.getWeeks().get(1).getNumberOfAppointments(), comparesEqualTo(2));
		assertThat(report.getWeeks().get(1).getYear(), comparesEqualTo(2020));
		assertThat(report.getWeeks().get(1).getAverageOutcomes(), comparesEqualTo(new BigDecimal(3)));
		assertThat(report.getWeeks().get(1).getCountPerType().get(CONSULTATION), comparesEqualTo(1L));
		assertThat(report.getWeeks().get(1).getCountPerType().get(EXAMINATION), comparesEqualTo(1L));


		assertThat(report.getWeeks().get(2).getNumberOfAppointments(), comparesEqualTo(1));
		assertThat(report.getWeeks().get(2).getYear(), comparesEqualTo(1999));
		assertThat(report.getWeeks().get(2).getAverageOutcomes(), comparesEqualTo(new BigDecimal(24)));
		assertThat(report.getWeeks().get(2).getCountPerType().get(CHECKUP), comparesEqualTo(1L));

	}

	private List<Appointment> generateAppointments() {
		return Arrays.asList(
				Appointment.builder().localDateTime(LocalDateTime.of(2020, 1, 5, 12, 0))
						.glicemia(BigDecimal.valueOf(1))
						.weight(BigDecimal.valueOf(1))
						.waistCircumference(BigDecimal.valueOf(1))
						.type(MEDICAL_PROCEDURE).build(),
				Appointment.builder().localDateTime(LocalDateTime.of(2020, 1, 6, 12, 0))
						.glicemia(BigDecimal.valueOf(3))
						.weight(BigDecimal.valueOf(3))
						.waistCircumference(BigDecimal.valueOf(3))
						.type(MEDICAL_PROCEDURE).build(),
				Appointment.builder().localDateTime(LocalDateTime.of(2020, 2, 1, 12, 0))
						.glicemia(BigDecimal.valueOf(1))
						.weight(BigDecimal.valueOf(1))
						.waistCircumference(BigDecimal.valueOf(1))
						.type(CONSULTATION).build(),
				Appointment.builder().localDateTime(LocalDateTime.of(2020, 2, 1, 12, 0))
						.glicemia(BigDecimal.valueOf(1))
						.weight(BigDecimal.valueOf(1))
						.waistCircumference(BigDecimal.valueOf(1))
						.type(EXAMINATION).build(),
				Appointment.builder().localDateTime(LocalDateTime.of(1999, 3, 1, 12, 0))
						.glicemia(BigDecimal.valueOf(8))
						.weight(BigDecimal.valueOf(8))
						.waistCircumference(BigDecimal.valueOf(8))
						.type(CHECKUP).build());
	}

}
