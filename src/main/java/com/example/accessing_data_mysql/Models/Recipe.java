package com.example.accessing_data_mysql.Models;

import jakarta.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Food")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "Ingredient")
    private Ingredient ingredient;

    public long getId(){
        return id;
    }

    public Food getFood() {
        return food;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
