package br.com.treinaweb.backend.api.pet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.backend.api.pet.dto.PetRequest;
import br.com.treinaweb.backend.api.pet.dto.PetResponse;
import br.com.treinaweb.backend.api.pet.mappers.PetMapper;
import br.com.treinaweb.backend.core.repositories.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;
    
    public List<PetResponse> findAll(){
        // var pets = petReposiroty.findAll();
        // var petResponses = new ArrayList<PetResponse>();
        // for (Pet pet : pets) {
        //     petResponses.add(petMapper.toResponse(pet));
        // }

        // return petResponses;

        return petRepository.findAll()
            .stream()
            .map(petMapper::toResponse)
            .collect(Collectors.toList());
    }

    public PetResponse create(PetRequest petRequest){
        var petToCreate = petMapper.toModel(petRequest);
        var createdPet = petRepository.save(petToCreate);
        return petMapper.toResponse(createdPet);
    }
}
