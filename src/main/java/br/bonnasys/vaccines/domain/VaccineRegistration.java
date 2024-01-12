package br.bonnasys.vaccines.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name="vaccine_registration")
public class VaccineRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="patient_id", foreignKey = @ForeignKey(name="fk_vr_patient_id"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="vaccine_id", foreignKey = @ForeignKey(name="fk_vr_vaccine_id"))
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name="health_center_id", foreignKey = @ForeignKey(name="fk_vr_health_center_id"))
    private HealthCenter healthCenter;

    private OffsetDateTime registrationDate;
}
