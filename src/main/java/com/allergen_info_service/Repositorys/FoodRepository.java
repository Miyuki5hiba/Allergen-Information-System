package com.allergen_info_service.Repositorys;

import com.allergen_info_service.Models.Food;
import org.springframework.data.repository.CrudRepository;


public interface FoodRepository extends CrudRepository<Food, Long>{
}
