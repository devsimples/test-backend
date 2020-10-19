package com.dev.simples.healthcare.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
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

    @Min(0) @Max(200)
    private BigDecimal weight;
}
