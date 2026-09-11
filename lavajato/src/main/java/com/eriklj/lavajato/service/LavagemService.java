package com.eriklj.lavajato.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eriklj.lavajato.entity.Lavagem;
import com.eriklj.lavajato.entity.TipoLavagem;
import com.eriklj.lavajato.entity.Usuario;
import com.eriklj.lavajato.repository.LavagemRepository;
import com.eriklj.lavajato.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service 
public class LavagemService {
    
    @Autowired 
    private LavagemRepository lavagemRepository;

    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Transactional 
    public Lavagem agendarLavagem(LocalDate data, LocalTime hora, Long idCliente, double valor, TipoLavagem tipo){
        Usuario cliente = usuarioRepository.findById(idCliente).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado: " + idCliente));

        Lavagem lavagem = new Lavagem(data, hora, cliente, valor, tipo);

        return lavagemRepository.save(lavagem);

    }
}
