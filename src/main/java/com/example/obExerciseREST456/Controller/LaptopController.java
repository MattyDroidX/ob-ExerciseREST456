package com.example.obExerciseREST456.Controller;

import com.example.obExerciseREST456.Entities.Laptop;
import com.example.obExerciseREST456.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    private final LaptopRepository laptopRepository;


    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> getAll(){
        return laptopRepository.findAll();
    }



    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }
}
