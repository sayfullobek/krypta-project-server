package it.universal.krypta.valyuta.server.repository;

import it.universal.krypta.valyuta.server.entity.VIPS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VipsRepository extends JpaRepository<VIPS,Integer> {
    boolean existsVIPSByEnNameAndRuNameAndUzNameEqualsIgnoreCase(String uzName,String ruName,String enName);

    boolean existsVIPSByEnNameAndRuNameAndUzNameEqualsIgnoreCaseIdNot(String uzName,String ruName,String enName,Integer id);

}
