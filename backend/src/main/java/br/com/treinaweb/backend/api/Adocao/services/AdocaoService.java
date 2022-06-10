package br.com.treinaweb.backend.api.Adocao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.backend.api.Adocao.dto.AdocaoRequest;
import br.com.treinaweb.backend.api.Adocao.dto.AdocaoResponse;
import br.com.treinaweb.backend.api.Adocao.mappers.AdocaoMapper;
import br.com.treinaweb.backend.core.repositories.AdocaoRepository;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private AdocaoMapper adocaoMapper;

    public AdocaoResponse create(AdocaoRequest adocaoRequest){
        var adocaoToCreate = adocaoMapper.toModel(adocaoRequest);
        var createdAdocao = adocaoRepository.save(adocaoToCreate);

        return adocaoMapper.toResponse(createdAdocao);
    }

    public List<AdocaoResponse> findAll(){
        return adocaoRepository.findAll()
            .stream()
            .map(adocaoMapper::toResponse)
            .collect(Collectors.toList());
    }
}
