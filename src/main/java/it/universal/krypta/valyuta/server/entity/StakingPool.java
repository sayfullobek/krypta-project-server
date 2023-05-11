package it.universal.krypta.valyuta.server.entity;

import it.universal.krypta.valyuta.server.entity.template.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StakingPool extends AbsEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String aboutPool; //ushbu page haqida ma'lumot

    @OneToMany
    private List<Pools> pools;
}
