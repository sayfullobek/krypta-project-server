package it.universal.krypta.valyuta.server.repository;

import it.universal.krypta.valyuta.server.entity.Coins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoinRepository extends JpaRepository<Coins, UUID> {
    boolean existsCoinsByNameEqualsIgnoreCase(String name);
    boolean existsCoinsByNameEqualsIgnoreCaseAndIdNot(String name, UUID id);
}
