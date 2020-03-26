package br.com.dev.simples.patients.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
	
	@Id
	private String id;

	@NotNull
	@Size(min = 3, max = 50)
	private String firstName;
	
	@Size(min = 3, max = 50)
	private String middleName;
	
	@Size(min = 3, max = 50)
	private String lastName;
	
	@Size(min = 3, max = 50)
	private String email;
}
