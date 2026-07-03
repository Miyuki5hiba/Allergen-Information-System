package com.allergen_info_service.Services;

import com.allergen_info_service.Models.Recipe;
import com.allergen_info_service.Repositorys.FoodRepository;
import com.allergen_info_service.Repositorys.IngredientRepository;
import com.allergen_info_service.Repositorys.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RecipeService implements AllergenFoodService<Recipe> {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    FoodService foodService;
    @Autowired
    IngredientService ingredientService;


    @Override
    public String home() {
        return "";
    }

    @Override
    public String newItemForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("foods", foodService.getAllItems());
        model.addAttribute("ingredients", ingredientService.getAllItems());
        return "Recipe/newRecipe";
    }

    @Override
    public String newItem(Recipe item, Model model) {
        Recipe newRecipe = new Recipe();
        newRecipe.setFood(foodRepository.findById(foodId).get());
        newRecipe.setIngredient(ingredientRepository.findById(ingredientId).get());
        recipeRepository.save(newRecipe);
        return "redirect:/allRecipes";
    }

    @Override
    public String modifyItem(long id, Recipe item) {
        recipeRepository.findById(index).map(
                existingRecipe-> {
                    existingRecipe.setIngredient(ingredientRepository.findById(ingredientId).get());
                    existingRecipe.setFood(foodRepository.findById(foodId).get());
                    recipeRepository.save(existingRecipe);
                    return null;
                }
        );
        return "redirect:/allRecipes";
    }

    @Override
    public String modifyItemForm(long id, Model model) {
        model.addAttribute("recipe", getRecipe(index));
        model.addAttribute("foods", getAllFood());
        model.addAttribute("ingredients", getAllIngredients());
        return "Recipe/modifyRecipe";
    }

    @Override
    public String getItemForm(long id, Model model) {
        model.addAttribute("ingredient", getRecipe(index));
        return "Recipe/getRecipe";
    }

    @Override
    public Recipe getItem(long id) {
        return recipeRepository.findById(index).get();
    }

    @Override
    public String allItems(Model model) {
        model.addAttribute("recipes", getAllRecipes());
        return "Recipe/allRecipes";
    }

    @Override
    public Iterable<Recipe> getAllItems() {
        return recipeRepository.findAll();
    }

    @Override
    public String deleteItemForm(long id, Model model) {
        model.addAttribute("recipe", getRecipe(index));
        return "Recipe/deleteRecipe";
    }

    @Override
    public String deleteItem(long id) {
        recipeRepository.delete(getRecipe(index));
        return "redirect:/allRecipes";
    }

}
