package com.dev.simples.healthcare.api;

import static com.dev.simples.healthcare.TestConfiguration.buildRestTemplate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.dev.simples.healthcare.dto.PatientDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class PatientApiIT {

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate = buildRestTemplate();

    @Test
    public void shouldReturnAllPatients() {
        String URI = "http://localhost:" + port + "/api/v1/patients";

        PatientDTO[] patients = restTemplate.getForEntity(URI, PatientDTO[].class).getBody();

        assertThat(patients.length, equalTo(2));
        assertThat(patients[0].getId(), equalTo("patient1"));
        assertThat(patients[1].getId(), equalTo("patient2"));
    }


}
