package it.universal.krypta.valyuta.server.controller;

import it.universal.krypta.valyuta.server.logic.Control;
import it.universal.krypta.valyuta.server.payload.Apiresponse;
import it.universal.krypta.valyuta.server.payload.VipsDto;
import it.universal.krypta.valyuta.server.repository.VipsRepository;
import it.universal.krypta.valyuta.server.service.VipsServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/vips")
@RequiredArgsConstructor
public class VipsController extends Control {

    private final VipsServise vipsServise;
    private final VipsRepository vipsRepository;
    @Override
    @GetMapping
    public HttpEntity<?> getVips() {
        return ResponseEntity.ok(vipsRepository.findAll());
    }

    @Override
    @PostMapping
    public HttpEntity<?> addVips(@RequestBody VipsDto vipsDto) {
        Apiresponse apiresponse=vipsServise.addVips(vipsDto);
        return ResponseEntity.status(apiresponse.isSuccess() ? 200 :409).body(apiresponse);
    }

    @Override
    public HttpEntity<?> editVips(Integer id, VipsDto vipsDto) {
        Apiresponse apiresponse=vipsServise.editVips(id,vipsDto);
        return ResponseEntity.status(apiresponse.isSuccess() ? 200 : 409).body(apiresponse);
    }

    @Override
    public HttpEntity<?> deleteVips(Integer id) {
        Apiresponse apiresponse=vipsServise.deleteVips(id);
        return ResponseEntity.status(apiresponse.isSuccess() ? 200 : 409).body(apiresponse);
    }
}
