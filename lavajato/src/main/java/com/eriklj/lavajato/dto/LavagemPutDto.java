package com.eriklj.lavajato.dto;

import java.time.*;

import com.eriklj.lavajato.model.TipoLavagem;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class LavagemPutDto {
    @JsonProperty("data")
    @NotBlank(message = "A data da lavagem é obrigatória")
    private LocalDate data;

    @JsonProperty("hora")
    @NotBlank(message = "A hora da lavagem é obrigatória")
    private LocalTime hora;

    @JsonProperty("tipoLavagem")
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O tipo da lavagem é obrigatório")
    private TipoLavagem tipo;
    
}
