package com.eriklj.lavajato.service;

import java.util.List;

import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;

import com.eriklj.lavajato.dto.UsuarioPostDto;
import com.eriklj.lavajato.dto.UsuarioPutDto;
import com.eriklj.lavajato.dto.UsuarioRespondeDto;
import com.eriklj.lavajato.model.Usuario;
import com.eriklj.lavajato.repository.UsuarioRepository;

import org.modelmapper.ModelMapper;


public class UsuarioCrudPadraoService implements UsuarioCrudService{

    @Autowired 
    ModelMapper modelMapper;

    @Autowired 
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioRespondeDto criarUsuario(UsuarioPostDto usuarioPostDto) {
        Usuario usuario = modelMapper.map(usuarioPostDto, Usuario.class);
        return modelMapper.map(usuarioRepository.save(usuario), UsuarioRespondeDto.class);
    }

    @Override
    public List<UsuarioRespondeDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioRespondeDto.class))
                .toList();
    }

    @Override
    public UsuarioRespondeDto buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return modelMapper.map(usuario, UsuarioRespondeDto.class);
    }

    @Override
    public UsuarioRespondeDto editarUsuario(Long id, UsuarioPutDto usuarioPutDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioPutDto.getNome());
        usuario.setEmail(usuarioPutDto.getEmail());

        return modelMapper.map(usuarioRepository.save(usuario), UsuarioRespondeDto.class);
    }

    @Override
    public void removeUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }
    
}
