package com.eriklj.lavajato.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eriklj.lavajato.dto.LavagemPostDto;
import com.eriklj.lavajato.dto.LavagemPutDto;
import com.eriklj.lavajato.dto.LavagemResponseDto;
import com.eriklj.lavajato.model.Lavagem;
import com.eriklj.lavajato.repository.LavagemRepository;

@Service 
public class LavagemCrudPadraoService implements LavagemCrudService{

    @Autowired 
    ModelMapper modelMapper;

    @Autowired 
    LavagemRepository lavagemRepository;


    @Override
    public LavagemResponseDto buscarLavagem(Long id) {
        Lavagem lavagem = lavagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lavagem não encontrada"));
        return modelMapper.map(lavagem, LavagemResponseDto.class);
    }

    @Override
    public LavagemResponseDto adicionarLavagem(LavagemPostDto lavagemPostDto) {
        Lavagem lavagem = modelMapper.map(lavagemPostDto, Lavagem.class);
        return modelMapper.map(lavagemRepository.save(lavagem), LavagemResponseDto.class);
    }

    @Override
    public List<LavagemResponseDto> listarLavagens() {
        return lavagemRepository.findAll()
                .stream()
                .map(lavagem -> modelMapper.map(lavagem, LavagemResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeLavagem(Long id) {
        Lavagem lavagem = lavagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lavagem não encontrada"));
        lavagemRepository.delete(lavagem);
    }

    @Override
    public LavagemResponseDto editarLavagem(Long id, LavagemPutDto lavagemPutDto) {
        Lavagem lavagemExistente = lavagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lavagem não encontrada"));

        modelMapper.map(lavagemPutDto, lavagemExistente);
        return modelMapper.map(lavagemRepository.save(lavagemExistente), LavagemResponseDto.class);
    }
    
}
