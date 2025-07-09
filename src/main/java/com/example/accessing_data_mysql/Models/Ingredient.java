package com.example.accessing_data_mysql.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

//    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "ingredient")
    private Set<Recipe> recipes;


    public long getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name.trim();
    }
    public String getName() {
        return name;
    }

    public Set<Recipe> getUsedIn() {
        return recipes;
    }

    public void setUsedIn(Set<Recipe> usedIn) {
        this.recipes = usedIn;
    }

}
