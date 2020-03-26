package br.com.dev.simples.patients.dto.report;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.dev.simples.patients.model.enumeration.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ReportWeekDTO {

	private Integer weekOfYear;
	private Integer numberOfAppointments;
	private Map<AppointmentType, Long> countPerType;
	private BigDecimal averageOutcomes;

	public ReportWeekDTO() {
		countPerType = new HashMap<AppointmentType, Long>();
	}
	
	public void setCountPerType(AppointmentType type, Long count)
	{
		countPerType.put(type, count);
	}
}
