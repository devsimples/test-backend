package br.com.dev.simples.patients.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.dev.simples.patients.model.enumeration.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private LocalDateTime localDateTime;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AppointmentType type;
	
	@NotNull
	@ManyToOne
	private Patient patient;
	
	private BigDecimal weight;
	
	@Column(name = "waist_circumference")
	private BigDecimal waistCircumference;
	
	private BigDecimal glicemia;
	
	@Transient
	public int getWeekOfYear() {
        WeekFields wf = WeekFields.of(Locale.getDefault());
        return localDateTime.get(wf.weekOfYear());
    }
	
	@Transient
	public int getYear() {
        return localDateTime.getYear();
    }
	
	@Transient
	public BigDecimal getSumOutcome() {
        BigDecimal outcome = new BigDecimal(0);

		outcome = outcome.add( getWeight() != null ? getWeight() : BigDecimal.ZERO );
		outcome = outcome.add( getGlicemia() != null ? getGlicemia() : BigDecimal.ZERO );
		outcome = outcome.add( getWaistCircumference() != null ? getWaistCircumference() : BigDecimal.ZERO );

        return outcome;
    }
}
