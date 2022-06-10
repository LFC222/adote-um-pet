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
		pet.setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwVmF65KsK347M3EixovVHKiRRDRjRaybinw&usqp=CAU");
		petRepository.save(pet);

		// Pet[] pets = new Pet[5];

		// pets[0].setNome("Dodo");
		// pets[0].setHistoria("Historia emocionante");
		// pets[0].setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwVmF65KsK347M3EixovVHKiRRDRjRaybinw&usqp=CAU");

		// pets[1].setNome("Lila");
		// pets[1].setHistoria("Historia emocionante");
		// pets[1].setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdEXVBd0Rc2oJK_eLLrzQdXI8xHpb9reVkmQ&usqp=CAU");

		// pets[2].setNome("Soneca");
		// pets[2].setHistoria("Historia emocionante");
		// pets[2].setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfY-UHpP_UuvmsROybiFPFlp8zusw7Nt_JPg&usqp=CAU");

		// pets[3].setNome("Thor & Loki");
		// pets[3].setHistoria("Historia emocionante");
		// pets[3].setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuXfm3YVxkws21Zkh9Fqt5JbLFgslxefVKWA&usqp=CAU");

		// pets[4].setNome("Dunga & Zangado");
		// pets[4].setHistoria("Historia emocionante");
		// pets[4].setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR35oxwiJBKfgo8j76YxBTmlPyJwB9kd2iJDg&usqp=CAU");

		// petRepository.save(pets[0]);
	}

}
