package com.eriklj.lavajato.repository;

import com.eriklj.lavajato.model.Lavagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LavagemRepository extends JpaRepository<Lavagem, Long> {
}