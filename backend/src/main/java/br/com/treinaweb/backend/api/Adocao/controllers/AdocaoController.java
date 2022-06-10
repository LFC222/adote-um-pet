package br.com.treinaweb.backend.api.Adocao.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.backend.api.Adocao.dto.AdocaoRequest;
import br.com.treinaweb.backend.api.Adocao.dto.AdocaoResponse;
import br.com.treinaweb.backend.api.Adocao.services.AdocaoService;

@RestController
@RequestMapping("/api/adocoes")
public class AdocaoController {
    
    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdocaoResponse create(@RequestBody @Valid AdocaoRequest adocaoRequest){
        return adocaoService.create(adocaoRequest);
    }

    @GetMapping
    public List<AdocaoResponse> findAll() {
        return adocaoService.findAll();
    } 

    
}
