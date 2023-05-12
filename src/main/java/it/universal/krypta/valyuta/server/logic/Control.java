package it.universal.krypta.valyuta.server.logic;

import it.universal.krypta.valyuta.server.payload.CoinDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public abstract class Control {
    public HttpEntity<?> getCoins() {
        return null;
    }

    public HttpEntity<?> addCoin(CoinDto coinDto) {
        return null;
    }

    public HttpEntity<?> editCoin(UUID id, CoinDto coinDto) {
        return null;
    }

    public HttpEntity<?> deleteCoin(UUID id) {
        return null;
    }
}
