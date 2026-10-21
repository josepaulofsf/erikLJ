package com.eriklj.lavajato.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.eriklj.lavajato.model.TipoLavagem;
import com.eriklj.lavajato.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class LavagemResponseDto {

    @JsonProperty("id_lavagem")
    private Long id;

    @JsonProperty("id_cliente")
    private Usuario cliente;

    @JsonProperty("tipoLavagem")
    @Enumerated(EnumType.STRING)
    private TipoLavagem tipoLavagem;

    @JsonProperty("data")
    private LocalDate data;

    @JsonProperty("hora")
    private LocalTime hora;
}
