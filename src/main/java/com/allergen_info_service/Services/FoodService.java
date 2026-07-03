package com.allergen_info_service.Services;

import com.allergen_info_service.Models.Food;
import com.allergen_info_service.Repositorys.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FoodService implements AllergenFoodService<Food>{

    @Autowired
    private FoodRepository foodRepository;

    public String home(){
        return "redirect:/";
    }

    @Override
    public String newItemForm(Model model) {
        model.addAttribute("food", new Food());
        return "Food/newFood";
    }

    @Override
    public String newItem(Food item, Model model) {
        Food fod = new Food();
        fod.setName(item.getName());
        foodRepository.save(fod);
        return "redirect:/allFood";
    }

    @Override
    public String modifyItem(long id, Food item) {
        foodRepository.findById(id).map(
                existingFood -> {
                    existingFood.setName(item.getName());
                    foodRepository.save(existingFood);
                    return null;    //new ResponseEntity<>(savedEntity, HttpStatus.OK); **Need to learn about this
                }

        );
        return "redirect:/allFood";
    }

    @Override
    public String modifyItemForm(long id, Model model) {
        model.addAttribute("food", getItem(id));
        return "Food/modifyFood";
    }

    @Override
    public String getItemForm(long id, Model model) {
        model.addAttribute("food", getItem(id));
        return "Food/getFood";
    }

    @Override
    public Food getItem(long id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public String allItems(Model model) {
        model.addAttribute("foods", getAllItems());
        return "Food/allFood";
    }

    @Override
    public Iterable<Food> getAllItems() {
        return foodRepository.findAll();
    }

    @Override
    public String deleteItemForm(long id, Model model) {
        model.addAttribute("food", getItem(id));
        return "Food/deleteFood";
    }

    @Override
    public String deleteItem(long id) {
        try{
            foodRepository.delete(getItem(id));
        }
        catch(Exception e){
            return "Error/DeleteForeignKeyF";
        }
        return "redirect:/allFood";
    }
}
