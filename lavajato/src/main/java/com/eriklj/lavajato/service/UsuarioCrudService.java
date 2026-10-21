package com.eriklj.lavajato.service;

import java.util.List;
import com.eriklj.lavajato.dto.UsuarioPostDto;
import com.eriklj.lavajato.dto.UsuarioPutDto;
import com.eriklj.lavajato.dto.UsuarioRespondeDto;

public interface UsuarioCrudService {
    
    UsuarioRespondeDto criarUsuario(UsuarioPostDto usuarioPostDto);

    List<UsuarioRespondeDto> listarUsuarios();

    UsuarioRespondeDto buscarUsuario(Long id);

    UsuarioRespondeDto editarUsuario(Long id, UsuarioPutDto usuarioPutDto); // provavelmente vou alterar para email

    void removeUsuario(Long id);
}
