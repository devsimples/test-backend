package br.com.dev.simples.patients.service;

import br.com.dev.simples.patients.model.report.AppointmentReport;
import br.com.dev.simples.patients.repository.AppointmentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentReportService {

    @Autowired
    private AppointmentReportRepository repository;

    public List<AppointmentReport> getReport(String patientId)
    {
        return repository.getReport(patientId);
    }
}
