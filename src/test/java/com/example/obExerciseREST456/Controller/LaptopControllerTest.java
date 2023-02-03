package com.example.obExerciseREST456.Controller;

import com.example.obExerciseREST456.Entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }


    @DisplayName("Testing HttpMehot GET for all devices")
    @Test
    void findAll() {
        ResponseEntity<List> response =
            testRestTemplate.getForEntity("/api/laptops", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @DisplayName("Testing HttpMehot GET for one device only")
    @Test
    void findById() {
        ResponseEntity<Laptop> response =
            testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @DisplayName("Testing HttpMehot POST to create device")
    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        String json= """
                {
                  "brand": "HP",
                  "model": "TLP32",
                  "yearOfFabrication": 2021
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops",HttpMethod.POST, request, Laptop.class);
        Laptop result = response.getBody();

        assert result != null;
        assertEquals(1L, result.getId());
        assertEquals("HP", result.getBrand());
    }
}