package com.dev.simples.healthcare.dto;

import com.dev.simples.healthcare.model.enumeration.AppointmentType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AppointmentDTO {

    private LocalDateTime dateTime;
    private AppointmentType type;
    private String patientId;
    private BigDecimal weight;
    private BigDecimal waistCircumference;
    private BigDecimal glicemia;

}
