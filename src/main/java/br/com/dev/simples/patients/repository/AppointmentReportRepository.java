package br.com.dev.simples.patients.repository;

import br.com.dev.simples.patients.model.report.AppointmentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AppointmentReportRepository extends JpaRepository<AppointmentReport, BigInteger> {

    @Query(name = "getAppointmentReport")
    public List<AppointmentReport> getReport( @Param("patientId") String patientId);

}
