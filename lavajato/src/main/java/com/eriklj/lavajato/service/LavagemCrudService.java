package com.eriklj.lavajato.service;

import java.util.List;

import com.eriklj.lavajato.dto.LavagemPostDto;
import com.eriklj.lavajato.dto.LavagemPutDto;
import com.eriklj.lavajato.dto.LavagemResponseDto;

public interface LavagemCrudService {
    
    LavagemResponseDto buscarLavagem(Long id);

    LavagemResponseDto adicionarLavagem(LavagemPostDto lavagemPostDto);

    List<LavagemResponseDto> listarLavagens();

    void removeLavagem(Long id);

    LavagemResponseDto editarLavagem(Long id, LavagemPutDto lavagemPutDto);
}
