CREATE TABLE appointments
  (
     id                  BIGINT NOT NULL,
     glicemia            DECIMAL(19, 2),
     date_time           TIMESTAMP NOT NULL,
     type                VARCHAR(255) NOT NULL,
     waist_circumference DECIMAL(19, 2),
     weight              DECIMAL(19, 2),
     patient_id          VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
  )
