package com.example.JpaTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JpaTutorialApplication {

	@RestController
	public class CityController {
		@Autowired
		CityRepository cityRepository;

		@GetMapping("/berlin")
		public City berlin() {
			return cityRepository.findByName("Berlin");
		}

		@GetMapping("/duesseldorf")
		public City duesseldorf() {
			return cityRepository.findByName("Duesseldorf");
		}
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(JpaTutorialApplication.class, args);

		City berlin = new City();
		berlin.setName("Berlin");
		berlin.setCapital(true);

		City duesseldorf = new City();
		duesseldorf.setCapital(false);
		duesseldorf.setName("Duesseldorf");

		CityRepository cityRepository = applicationContext.getBean(CityRepository.class);
		cityRepository.save(berlin);
		cityRepository.save(duesseldorf);
	}

}
