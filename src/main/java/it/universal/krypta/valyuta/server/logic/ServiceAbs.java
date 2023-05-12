package it.universal.krypta.valyuta.server.logic;

import it.universal.krypta.valyuta.server.payload.Apiresponse;
import it.universal.krypta.valyuta.server.payload.CoinDto;

import java.util.UUID;

public abstract class ServiceAbs {
    public Apiresponse addCoin(CoinDto coinDto) {
        return null;
    }

    public Apiresponse editCoin(UUID id, CoinDto coinDto) {
        return null;
    }

    public Apiresponse deleteCoin(UUID id) {
        return null;
    }
}
