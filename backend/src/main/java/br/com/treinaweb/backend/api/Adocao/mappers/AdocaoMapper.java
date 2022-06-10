package br.com.treinaweb.backend.api.Adocao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinaweb.backend.api.Adocao.dto.AdocaoRequest;
import br.com.treinaweb.backend.api.Adocao.dto.AdocaoResponse;
import br.com.treinaweb.backend.api.pet.mappers.PetMapper;
import br.com.treinaweb.backend.core.models.Adocao;
import br.com.treinaweb.backend.core.repositories.PetRepository;

@Component
public class AdocaoMapper {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;


    public Adocao toModel(AdocaoRequest adocaoRequest){
        // var adocao = new Adocao();
        // adocao.setEmail(adocaoRequest.getEmail());
        // adocao.setValor(adocaoRequest.getValor());
        // adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()));
        // return adocao;

        return Adocao.builder()
            .email(adocaoRequest.getEmail())
            .valor(adocaoRequest.getValor())
            .pet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()))
            .build();
    }

    public AdocaoResponse toResponse(Adocao adocao){
        // var adocaoResponse = new AdocaoResponse();
        // adocaoResponse.setId(adocao.getId());
        // adocaoResponse.setEmail(adocao.getEmail());
        // adocaoResponse.setValor(adocao.getValor());
        // adocaoResponse.setPet(petMapper.toResponse(adocao.getPet())); 
        // return adocaoResponse;

        return AdocaoResponse.builder()
            .id(adocao.getId())
            .email(adocao.getEmail())
            .valor(adocao.getValor())
            .pet(petMapper.toResponse(adocao.getPet()))
            .build();
    }
}
