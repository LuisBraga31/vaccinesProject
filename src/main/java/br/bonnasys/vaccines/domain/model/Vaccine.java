package br.bonnasys.vaccines.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name= "vaccines")
public class Vaccine {

    @Id
    @Column(length= 36)
    private String id;
    private String vaccine;
    private String producer;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
