package br.com.treinaweb.backend.api.pet.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.backend.api.pet.dto.PetResponse;
import br.com.treinaweb.backend.core.models.Pet;

@Component
public class PetMapper {
    
    public PetResponse toResponse(Pet pet){
        var petResponse = new PetResponse();

        petResponse.setId(pet.getId());
        petResponse.setNome(pet.getNome());
        petResponse.setHistoria(pet.getHistoria());
        petResponse.setFoto(pet.getFoto());
        return petResponse;
    }
}
