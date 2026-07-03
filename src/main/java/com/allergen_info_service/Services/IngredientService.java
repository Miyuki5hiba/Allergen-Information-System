package com.allergen_info_service.Services;

import com.allergen_info_service.Models.Ingredient;
import com.allergen_info_service.Repositorys.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class IngredientService implements AllergenFoodService<Ingredient> {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public String home(){
        return "redirect:/";
    }

    @Override
    public String newItemForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "Ingredient/newIngredient";
    }

    @Override
    public String newItem(Ingredient item, Model model) {
        Ingredient newIngredient = new Ingredient();
        newIngredient.setName(item.getName());
        ingredientRepository.save(newIngredient);
        return "redirect:/allIngredients";
    }

    @Override
    public String modifyItem(long id, Ingredient item) {
        ingredientRepository.findById(id).map(
                existingIngredient-> {
                    existingIngredient.setName(item.getName());
                    ingredientRepository.save(existingIngredient);
                    return null;
                }
        );
        return "redirect:/allIngredients";
    }

    @Override
    public String modifyItemForm(long id, Model model) {
        model.addAttribute("ingredient", getItem(id));
        return "Ingredient/modifyIngredient";
    }

    @Override
    public String getItemForm(long id, Model model) {
        model.addAttribute("ingredient", getItem(id));
        return "Ingredient/getIngredient";
    }

    @Override
    public Ingredient getItem(long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public String allItems(Model model) {
        model.addAttribute("ingredients", getAllItems());
        return "Ingredient/allIngredients";
    }

    @Override
    public Iterable<Ingredient> getAllItems() {
        return ingredientRepository.findAll();
    }

    @Override
    public String deleteItemForm(long id, Model model) {
        model.addAttribute("ingredient", getItem(id));
        return "Ingredient/deleteIngredient";
    }

    @Override
    public String deleteItem(long id) {
        try{
            ingredientRepository.delete(getItem(id));
        }
        catch(Exception e){
            return "Error/DeleteForeignKeyI";
        }
        return "redirect:/allIngredients";
    }
}
