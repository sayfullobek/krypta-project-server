package it.universal.krypta.valyuta.server.entity;

import it.universal.krypta.valyuta.server.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Coins extends AbsNameEntity {
    private UUID photoId; //coinning rasmi
    private double percentage; //coinning fozi
    private double dollar; //coinning dollari
    private boolean active; //ushbu coin activmi yoqmi
}
