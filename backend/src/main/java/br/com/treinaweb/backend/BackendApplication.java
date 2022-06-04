package br.com.treinaweb.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.treinaweb.backend.core.models.Pet;
import br.com.treinaweb.backend.core.repositories.PetRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var pet = new Pet();
		pet.setNome("Dodo");
		pet.setHistoria("Historia emocionante");
		pet.setFoto("http://www.exemplo.com.br/foto.png");
		petRepository.save(pet);
		
	}

}
