package com.eriklj.lavajato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eriklj.lavajato.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
} 
