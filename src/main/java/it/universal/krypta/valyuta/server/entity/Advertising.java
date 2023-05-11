package it.universal.krypta.valyuta.server.entity;

import it.universal.krypta.valyuta.server.entity.template.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Collections;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Advertising extends AbsEntity {//ushbu appning carousel reklamasi
    @Column(nullable = false, unique = true)
    private UUID id; //reklama rasmi
}
