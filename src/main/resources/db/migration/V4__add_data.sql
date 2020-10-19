insert into patients(id, first_name, middle_name, last_name, email, weight)
  values('patient1', 'Patient 1', 'Middle', 'Last', 'patient1@gmail.com', 65.0);

insert into patients(id, first_name, middle_name, last_name, email, weight)
  values('patient2', 'Patient 2', 'Middle', 'Last', 'patient2@gmail.com', 72.5);

insert into appointments(id, date_time, type, patient_id)
  values(1, NOW(), 'CHECKUP', 'patient1')