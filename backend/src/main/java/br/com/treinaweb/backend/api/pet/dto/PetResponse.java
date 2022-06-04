package br.com.treinaweb.backend.api.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetResponse {
    
    private Long id;
    private String nome;
    private String historia;
    private String foto;
}