package com.example.obExerciseREST456.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Integer yearOfFabrication;


    public Laptop(){}
    public Laptop(Long id, String brand, String model, Integer yearOfFabrication) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfFabrication = yearOfFabrication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(Integer yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfFabrication=" + yearOfFabrication +
                '}';
    }
}
