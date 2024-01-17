package br.bonnasys.vaccines.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
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

    @OneToMany
    //@JoinColumn(foreignKey = @ForeignKey(name="fk_vr_history"))
    private List<VaccineRegistration> history;

}
