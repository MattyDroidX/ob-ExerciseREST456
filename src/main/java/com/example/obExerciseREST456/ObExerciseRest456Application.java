package com.example.obExerciseREST456;

import com.example.obExerciseREST456.Entities.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObExerciseRest456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObExerciseRest456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop notebook = new Laptop(null, "Lenovo", "Thinkpad",2020);
		Laptop notebook1 = new Laptop(null, "Sony", "Ultrabook",2021);
		Laptop notebook2 = new Laptop(null, "Dell", "StoneAge",2021);
		Laptop notebook3 = new Laptop(null, "Apple", "MacBook Pro",2022);
		repository.save(notebook);
		repository.save(notebook1);
		repository.save(notebook2);
		repository.save(notebook3);
	}

}
