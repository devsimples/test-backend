package br.com.dev.simples.patients.model.report;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SqlResultSetMapping(
        name = "appointmentReportMapping",
        classes = {
                @ConstructorResult(
                        targetClass = AppointmentReport.class,
                        columns = {
                                @ColumnResult(name = "rownumber"),
                                @ColumnResult(name = "year"),
                                @ColumnResult(name = "week"),
                                @ColumnResult(name = "appointment_count"),
                                @ColumnResult(name = "checkup"),
                                @ColumnResult(name = "consultation"),
                                @ColumnResult(name = "examination"),
                                @ColumnResult(name = "medical_procedure"),
                                @ColumnResult(name = "routine"),
                                @ColumnResult(name = "average"),
                        }
                )
        }
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getAppointmentReport",
                query = "SELECT \n" +
                        "rownum as rownumber, \n" +
                        "YEAR(a.LOCAL_DATE_TIME) AS year, \n" +
                        "WEEK(a.LOCAL_DATE_TIME) AS week,\n" +
                        "COUNT(1) APPOINTMENT_COUNT,\n" +
                        "SUM(CASE WHEN A.TYPE='CHECKUP' THEN 1 ELSE 0 END) AS CHECKUP,\n" +
                        "SUM(CASE WHEN A.TYPE='CONSULTATION' THEN 1 ELSE 0 END) AS CONSULTATION,\n" +
                        "SUM(CASE WHEN A.TYPE='EXAMINATION' THEN 1 ELSE 0 END) AS EXAMINATION,\n" +
                        "SUM(CASE WHEN A.TYPE='MEDICAL_PROCEDURE' THEN 1 ELSE 0 END) AS MEDICAL_PROCEDURE,\n" +
                        "SUM(CASE WHEN A.TYPE='ROUTINE' THEN 1 ELSE 0 END) AS ROUTINE,\n" +
                        "(SUM( a.WEIGHT + a.GLICEMIA + a.WAIST_CIRCUMFERENCE ) / COUNT(1)) AS AVERAGE\n" +
                        "FROM APPOINTMENTS a\n" +
                        "WHERE PATIENT_ID = :patientId \n" +
                        "GROUP BY year, week",
                resultSetMapping = "appointmentReportMapping"
        )
})
public class AppointmentReport implements Serializable {


    @Id
    private BigInteger rownumber;

    private Integer year;

    private Integer week;

    @Column(name = "appointment_count")
    private BigInteger appointmentCount;

    private BigInteger checkup;

    private BigInteger consultation;

    private BigInteger examination;

    @Column(name = "medical_procedure")
    private BigInteger medicalProcedure;

    private BigInteger routine;

    private BigDecimal average;

}
