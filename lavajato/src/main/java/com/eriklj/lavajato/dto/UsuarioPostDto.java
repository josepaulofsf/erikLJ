package com.eriklj.lavajato.dto;

import com.eriklj.lavajato.model.TipoUsuario;
import com.eriklj.lavajato.model.Usuario;
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
public class UsuarioPostDto {
    @JsonProperty ("nome")
    @NotBlank(message = "O nome do usuário é obrigatório")
    private String nome;

    @JsonProperty ("email")
    @NotBlank(message = "O email do usuário é obrigatório")
    private String email;

    @JsonProperty ("tipo")
    @NotBlank(message = "O tipo do usuário é obrigatório")
    private TipoUsuario tipo;

    @JsonProperty ("senha")
    @NotBlank(message = "A senha do usuário é obrigatório")
    private String senha;
}
