package br.com.dev.simples.patients.repository;

import br.com.dev.simples.patients.model.report.AppointmentReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.core.IsNull.notNullValue;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentReportRepository repository;

    @Test
    public void shouldGetWeeks()
    {
        List<AppointmentReport> report = repository.getReport("marcos");
        assertThat(report, notNullValue());

        assertThat(report.size(), comparesEqualTo(2));

        assertThat(report.get(0).getAppointmentCount(), comparesEqualTo(BigInteger.ONE));
        assertThat(report.get(1).getAppointmentCount(), comparesEqualTo(BigInteger.valueOf(2)));

    }
}
