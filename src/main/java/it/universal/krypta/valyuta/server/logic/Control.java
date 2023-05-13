package it.universal.krypta.valyuta.server.logic;

import it.universal.krypta.valyuta.server.payload.CoinDto;
import it.universal.krypta.valyuta.server.payload.VipsDto;
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


    //start asl control VIPS

    public HttpEntity<?> getVips() {
        return null;
    }

    public HttpEntity<?> addVips(VipsDto vipsDto) {
        return null;
    }

    public HttpEntity<?> editVips(Integer id, VipsDto vipsDto) {
        return null;
    }

    public HttpEntity<?> deleteVips(Integer id) {
        return null;
    }

    //end asl control VIPS
}
