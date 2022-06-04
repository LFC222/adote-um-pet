package br.com.treinaweb.backend.core.repositories;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.backend.core.models.Pet;

public interface PetRepository extends JpaRepository<Pet,Long>{
    
    default Pet findByIdOrElseThrow(Long id){
        var petOptional = findById(id);

        if(petOptional.isPresent()){
            return petOptional.get();
        }
        throw new EntityNotFoundException();
    }
}
