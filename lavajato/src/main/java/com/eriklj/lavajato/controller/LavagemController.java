package com.eriklj.lavajato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eriklj.lavajato.dto.LavagemPostDto;
import com.eriklj.lavajato.dto.LavagemPutDto;
import com.eriklj.lavajato.dto.LavagemResponseDto;
import com.eriklj.lavajato.service.LavagemCrudService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/lavagens", produces = MediaType.APPLICATION_JSON_VALUE)
public class LavagemController {

    @Autowired
    private LavagemCrudService lavagemCrudService;

    @PostMapping
    public ResponseEntity<LavagemResponseDto> adicionarLavagem(@RequestBody @Valid LavagemPostDto lavagemPostDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lavagemCrudService.adicionarLavagem(lavagemPostDto));
    }

    @GetMapping
    public ResponseEntity<List<LavagemResponseDto>> listarLavagens() {
        return ResponseEntity.ok(lavagemCrudService.listarLavagens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LavagemResponseDto> buscarLavagem(@PathVariable Long id) {
        return ResponseEntity.ok(lavagemCrudService.buscarLavagem(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LavagemResponseDto> editarLavagem(@PathVariable Long id,
            @RequestBody @Valid LavagemPutDto lavagemPutDto) {
        return ResponseEntity.ok(lavagemCrudService.editarLavagem(id, lavagemPutDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLavagem(@PathVariable Long id) {
        lavagemCrudService.removeLavagem(id);
        return ResponseEntity.noContent().build();
    }
}
