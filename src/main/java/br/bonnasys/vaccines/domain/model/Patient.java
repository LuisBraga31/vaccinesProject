package br.bonnasys.vaccines.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String phone;
    private String email;
    private LocalDate birthdate;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    //@JoinColumn(foreignKey = @ForeignKey(name="fk_vr_history"))
    private List<VaccineRegistration> history;

    @PrePersist
    public void prePersist() {
        this.createdAt = OffsetDateTime.now();
    }

    public Patient(String name, String phone, String email, LocalDate birthdate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
    }
}
