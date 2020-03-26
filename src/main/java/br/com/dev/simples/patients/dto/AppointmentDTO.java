package br.com.dev.simples.patients.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.dev.simples.patients.model.enumeration.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

	private LocalDateTime localDateTime;
	private AppointmentType type;
	private String patientId;
	private BigDecimal weight;
	private BigDecimal waistCircumference;
	private BigDecimal glicemia;

}
