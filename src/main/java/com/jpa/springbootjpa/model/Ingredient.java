package com.jpa.springbootjpa.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    //Lazy - wzorzec projektowy odroczenie inicjalizacji obiektu, najpóźniej jak to tylko możliwe
    //do ostatniego momentu nie chce oddać danych. N+1 zapytań, taki problem:
    //zaptyuje wszystkie elemnty i potem każdy osobno plus 1
    //Eager - czy chcesz czy nie chcesz to bierz wszystkie elementy od klasy UnitOfMeasuer czy są potrzebne czy nie
    //zachłanne pobieranie danych.

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasuer uom;

    public Ingredient() {
    }

    public Ingredient(Long id, String description, BigDecimal amount, Recipe recipe, UnitOfMeasuer uom) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.uom = uom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasuer getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasuer uom) {
        this.uom = uom;
    }
}
