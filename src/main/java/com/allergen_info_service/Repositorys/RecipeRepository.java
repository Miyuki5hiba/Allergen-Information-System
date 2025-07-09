package com.allergen_info_service.Repositorys;

import com.allergen_info_service.Models.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
