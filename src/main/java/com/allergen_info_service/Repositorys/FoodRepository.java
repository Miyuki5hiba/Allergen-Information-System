package com.allergen_info_service.Repositorys;

import com.allergen_info_service.Models.Food;
import org.springframework.data.repository.CrudRepository;

// Find out what crud repositories are and what they do
public interface FoodRepository extends CrudRepository<Food, Long>{
}
