package br.com.treinaweb.backend.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.backend.core.models.Adocao;

public interface AdocaoRepository extends JpaRepository<Adocao,Long>{
    
}
