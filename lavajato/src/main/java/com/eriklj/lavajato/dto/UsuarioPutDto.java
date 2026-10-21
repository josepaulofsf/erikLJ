package com.eriklj.lavajato.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder 
@AllArgsConstructor 
@NoArgsConstructor 

public class UsuarioPutDto {
    @JsonProperty ("nome")
    @NotBlank(message = "O nome do usuário é obrigatório")
    private String nome;

    @JsonProperty ("email")
    @NotBlank(message = "O email do usuário é obrigatório")
    private String email;
}
