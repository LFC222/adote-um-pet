package br.com.treinaweb.backend.api.pet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.backend.api.pet.dto.PetResponse;
import br.com.treinaweb.backend.api.pet.mappers.PetMapper;
import br.com.treinaweb.backend.core.models.Pet;
import br.com.treinaweb.backend.core.repositories.PetRepository;

@RestController
public class PetController {
    
    @Autowired
    private PetRepository petReposiroty;

    @Autowired
    private PetMapper petMapper;

    @GetMapping("/api/pets")
    public List<PetResponse> findAll(){
        var pets = petReposiroty.findAll();
        var petResponses = new ArrayList<PetResponse>();
        for (Pet pet : pets) {
            petResponses.add(petMapper.toResponse(pet));
        }

        return petResponses;
    }
}
