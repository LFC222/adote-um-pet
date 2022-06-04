package br.com.treinaweb.backend.api.Adocao.dto;

import java.math.BigDecimal;

import br.com.treinaweb.backend.api.pet.dto.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoResponse {
    private Long id;
    private String email;
    private BigDecimal valor;
    private PetResponse pet;

}
