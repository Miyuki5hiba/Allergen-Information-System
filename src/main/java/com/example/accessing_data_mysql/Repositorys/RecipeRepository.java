package com.example.accessing_data_mysql.Repositorys;

import com.example.accessing_data_mysql.Models.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
