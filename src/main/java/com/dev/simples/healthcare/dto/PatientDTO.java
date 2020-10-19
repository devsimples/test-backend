package com.dev.simples.healthcare.dto;

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
public class PatientDTO {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
}
