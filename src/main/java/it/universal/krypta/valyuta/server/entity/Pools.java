package it.universal.krypta.valyuta.server.entity;

import it.universal.krypta.valyuta.server.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pools extends AbsNameEntity {
    @Column(nullable = false, unique = true)
    private UUID photoId;

    @Column(nullable = false)
    private double annualizedInterest; //ushbu hovuzning yillik foizi

    private String mstakingMinimum; //minimal stavka

}
