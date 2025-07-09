//package com.example.accessing_data_mysql.Models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//
//import java.util.Objects;
//
//@Embeddable
//public class RecipeKey {
//    @Column(name = "Food")
//    String food;
//
//    @Column(name = "Ingredient")
//    String ingredient;
//    //Can add more later?
//
//
//    public String  getFood(){
//        return food;
//    }
//
//    public String getIngredient() {
//        return ingredient;
//    }
//
//    public void setFood(String food) {
//        this.food = food;
//    }
//
//    public void setIngredient(String ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RecipeKey key = (RecipeKey) o;
//        return food.equals(key.food) && ingredient.equals(key.ingredient);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(food, ingredient);
//    }
//}
