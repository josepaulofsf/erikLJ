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

import com.eriklj.lavajato.dto.UsuarioPostDto;
import com.eriklj.lavajato.dto.UsuarioPutDto;
import com.eriklj.lavajato.dto.UsuarioRespondeDto;
import com.eriklj.lavajato.service.UsuarioCrudService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private UsuarioCrudService usuarioCrudService;

    @PostMapping
    public ResponseEntity<UsuarioRespondeDto> criarUsuario(@RequestBody @Valid UsuarioPostDto usuarioPostDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioCrudService.criarUsuario(usuarioPostDto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRespondeDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioCrudService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespondeDto> buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioCrudService.buscarUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRespondeDto> editarUsuario(@PathVariable Long id,
            @RequestBody @Valid UsuarioPutDto usuarioPutDto) {
        return ResponseEntity.ok(usuarioCrudService.editarUsuario(id, usuarioPutDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        usuarioCrudService.removeUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
