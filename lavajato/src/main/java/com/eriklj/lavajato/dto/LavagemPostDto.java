package com.eriklj.lavajato.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.eriklj.lavajato.model.TipoLavagem;
import com.eriklj.lavajato.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;

public class LavagemPostDto {
 
    @JoinColumn(name = "id_cliente")
    @NotBlank(message = "O id do usuário é obrigatório")
    private Usuario cliente;

    @JsonProperty("tipoLavagem")
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O tipo da lavagem é obrigatório")
    private TipoLavagem tipoLavagem;

    @JsonProperty("data")
    @NotBlank(message = "a data da lavagem é obrigatória")
    private LocalDate data;

    @JsonProperty("hora")
    @NotBlank(message = "A hora da lavagem é obrigatória")
    private LocalTime hora;
}
