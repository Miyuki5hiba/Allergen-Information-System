package com.example.accessing_data_mysql.Repositorys;

import com.example.accessing_data_mysql.Models.Food;
import org.springframework.data.repository.CrudRepository;


public interface FoodRepository extends CrudRepository<Food, Long>{
}
