package br.com.treinaweb.backend.api.Adocao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.backend.api.Adocao.dto.AdocaoRequest;
import br.com.treinaweb.backend.api.Adocao.dto.AdocaoResponse;
import br.com.treinaweb.backend.api.Adocao.mappers.AdocaoMapper;
import br.com.treinaweb.backend.core.repositories.AdocaoRepository;

@RestController
public class AdocaoController {
    
    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private AdocaoMapper adocaoMapper;

    @PostMapping("/api/adocoes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdocaoResponse create(@RequestBody AdocaoRequest adocaoRequest){
        var adocao = adocaoMapper.toModel(adocaoRequest);
        var createdAdocao = adocaoRepository.save(adocao);
        return adocaoMapper.toResponse(createdAdocao);
    } 
}
