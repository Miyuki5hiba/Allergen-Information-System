package com.allergen_info_service.Repositorys;

import com.allergen_info_service.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
}
