package com.dev.simples.healthcare.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.dev.simples.healthcare.dto.PatientDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class PatientTest {

    private ModelMapper modelMapper = new ModelMapper();
    private Patient patient;
    private PatientDTO patientDTO;

    @Before
    public void before() {
        patient = new Patient()
                .setId("UUID")
                .setEmail("marcos.agostta@gmail.com")
                .setFirstName("Marcos")
                .setMiddleName("Rogério")
                .setLastName("Agostta");

        patientDTO = new PatientDTO()
                .setId("UUID")
                .setEmail("marcos.agostta@gmail.com")
                .setFirstName("Marcos")
                .setMiddleName("Rogério")
                .setLastName("Agostta");
    }

    @Test
    public void shouldConvertModelToDTO() {
        PatientDTO dto = modelMapper.map(patient, PatientDTO.class);

        assertThat(dto.getId(), equalTo(patient.getId()));
        assertThat(dto.getEmail(), equalTo(patient.getEmail()));
        assertThat(dto.getFirstName(), equalTo(patient.getFirstName()));
        assertThat(dto.getMiddleName(), equalTo(patient.getMiddleName()));
        assertThat(dto.getLastName(), equalTo(patient.getLastName()));
    }

    @Test
    public void shouldConvertDTOToModel() {
        Patient model = modelMapper.map(patientDTO, Patient.class);

        assertThat(model.getId(), equalTo(patientDTO.getId()));
        assertThat(model.getEmail(), equalTo(patientDTO.getEmail()));
        assertThat(model.getFirstName(), equalTo(patientDTO.getFirstName()));
        assertThat(model.getMiddleName(), equalTo(patientDTO.getMiddleName()));
        assertThat(model.getLastName(), equalTo(patientDTO.getLastName()));
    }

}
