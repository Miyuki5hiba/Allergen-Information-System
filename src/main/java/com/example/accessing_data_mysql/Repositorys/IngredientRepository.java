package com.example.accessing_data_mysql.Repositorys;

import com.example.accessing_data_mysql.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
}
