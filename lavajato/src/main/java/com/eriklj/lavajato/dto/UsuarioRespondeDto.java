package com.eriklj.lavajato.dto;

import com.eriklj.lavajato.model.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class UsuarioRespondeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome") 
    private String nome;

    @JsonProperty("email")
    private String email;

    //@JsonProperty("senha")
    //private String senha;

    @JsonProperty("tipo")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
}
