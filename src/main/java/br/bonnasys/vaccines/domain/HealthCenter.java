package br.bonnasys.vaccines.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name="healthcenter")
public class HealthCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length= 36)
    private String id;
    private String name;
    private String address;
    private String state;
    private String neighborhood;

    @ElementCollection
    @CollectionTable(name="vaccine_stock",
            joinColumns = @JoinColumn(name="health_center_id",
                    foreignKey = @ForeignKey(name="health_center_hc_id")))
    @MapKeyJoinColumn(name="vaccine_id", foreignKey = @ForeignKey(name = "health_center_vaccine_id"))
    @Column(name="amount")
    private Map<Vaccine, Integer> stock;

    private OffsetDateTime createdAt;
    private OffsetDateTime updateAt;


}
