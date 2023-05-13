package it.universal.krypta.valyuta.server.logic;

import it.universal.krypta.valyuta.server.payload.Apiresponse;
import it.universal.krypta.valyuta.server.payload.CoinDto;
import it.universal.krypta.valyuta.server.payload.VipsDto;

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

    //Asl Okang
    public Apiresponse addVips(VipsDto coinDto) {
        return null;
    }

    public Apiresponse editVips(Integer id, VipsDto coinDto) {
        return null;
    }

    public Apiresponse deleteVips(Integer id) {
        return null;
    }
    //end
}
