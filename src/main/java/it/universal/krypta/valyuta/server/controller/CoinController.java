package it.universal.krypta.valyuta.server.controller;

import it.universal.krypta.valyuta.server.logic.Control;
import it.universal.krypta.valyuta.server.payload.Apiresponse;
import it.universal.krypta.valyuta.server.payload.CoinDto;
import it.universal.krypta.valyuta.server.repository.CoinRepository;
import it.universal.krypta.valyuta.server.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/coin")
@RequiredArgsConstructor
public class CoinController extends Control {
    private final CoinService coinService;
    private final CoinRepository coinRepository;

    @Override
    @GetMapping
    public HttpEntity<?> getCoins() {
        return ResponseEntity.ok(coinRepository.findAll());
    }

    @Override
    @PostMapping
    public HttpEntity<?> addCoin(@RequestBody CoinDto coinDto) {
        Apiresponse apiresponse = coinService.addCoin(coinDto);
        return ResponseEntity.status(apiresponse.isSuccess() ? 200 : 409).body(apiresponse);
    }

    @Override
    @PutMapping("/{id}")
    public HttpEntity<?> editCoin(@PathVariable UUID id, @RequestBody CoinDto coinDto) {
        Apiresponse apiresponse = coinService.editCoin(id, coinDto);
        return ResponseEntity.status(apiresponse.isSuccess() ? 200 : 409).body(apiresponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCoin(@PathVariable UUID id) {
        Apiresponse apiresponse = coinService.deleteCoin(id);
        return ResponseEntity.status(apiresponse.isSuccess() ? 200 : 409).body(apiresponse);
    }
}
