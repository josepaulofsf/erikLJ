package com.eriklj.lavajato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eriklj.lavajato.entity.Lavagem;

public interface LavagemRepository extends JpaRepository<Lavagem, Long>{
    
}
