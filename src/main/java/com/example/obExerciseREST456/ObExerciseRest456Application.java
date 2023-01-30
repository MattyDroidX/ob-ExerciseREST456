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
		repository.save(notebook);
	}

}
