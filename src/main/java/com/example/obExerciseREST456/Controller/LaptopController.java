package com.example.obExerciseREST456.Controller;

import com.example.obExerciseREST456.Entities.Laptop;
import com.example.obExerciseREST456.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);


    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> OptLaptop =  laptopRepository.findById(id);
        return OptLaptop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }


    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop>updateLaptop(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("Laptop ID does not exist!");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Laptop does not exist!");
            return ResponseEntity.notFound().build();
        }
        Laptop result =laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop>delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Laptop does not exist!");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop>deleteAll(){
        log.info("REST request Delete all information of laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
