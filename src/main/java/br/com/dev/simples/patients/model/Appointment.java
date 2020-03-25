package br.com.dev.simples.patients.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	
	@Enumerated(EnumType.STRING)
	private AppointmentType type;
	
	@NotNull
	@ManyToOne
	private Patient patient;
	
	private double weight;
	
	@Column(name = "waist_circumference")
	private double waistCircumference;
	
	private double glicemia;
	
}
