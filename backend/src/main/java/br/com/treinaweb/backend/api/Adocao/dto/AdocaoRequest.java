package br.com.treinaweb.backend.api.Adocao.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class AdocaoRequest {


    @NotNull
    @Positive
    private Long petId;

    @Email
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String email;

    @Min(10)
    @Max(100)
    @NotNull
    private BigDecimal valor;
    
}
