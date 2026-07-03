package com.allergen_info_service.Controllers;

import com.allergen_info_service.Models.Food;
import com.allergen_info_service.Models.Ingredient;
import com.allergen_info_service.Services.BasicServiceImpl;
import com.allergen_info_service.Services.FoodService;
import com.allergen_info_service.Services.IngredientService;
import com.allergen_info_service.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;


@Controller
//@RequestMapping(path = "/")
public class MainController {
    @Autowired
    FoodService foodService;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    RecipeService recipeService;

    @GetMapping({"/", "/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/newFood")
    public String newFoodForm(Model model) {
        return foodService.newItemForm(model);
    }

    @PostMapping("/newFood")
    public String newFood(@ModelAttribute Food food, Model model){
        return foodService.newItem(food, model);
    }

    @GetMapping(path="/getFood")
    public String getFood(@RequestParam long foodId, Model model){
        return foodService.getItem(foodId,model);
    }

    @GetMapping("/allFood")
    public String allFood(Model model){
        return foodService.allItems(model);
    }

    @GetMapping("/deleteFood")
    public String deleteFoodForm(@RequestParam long foodId, Model model) {
        return foodService.deleteItemForm(foodId,model);
    }

    @DeleteMapping("/deleteFood")
    public String deleteFood(@RequestParam long foodId) {
        return foodService.deleteItem(foodId);
    }

    @GetMapping("/modifyFood")
    public String modifyFood(@RequestParam long foodId, Model model) {
        return foodService.modifyItem(foodId,model);
    }

    @PutMapping("/modifyFood")
    public String modifyFood(@RequestParam long foodId, @ModelAttribute Food food){
        return foodService.modifyItem(foodId, food);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newIngredient")
    public String newIngredientForm(Model model) {
        return ingredientService.newItemForm(model);
    }

    @PostMapping("/newIngredient")
    public String newIngredient(@ModelAttribute Ingredient ingredient, Model model){
        return ingredientService.newItem(ingredient, model);
    }

    @GetMapping(path="/getIngredient")
    public String getIngredient(@RequestParam long ingredientId, Model model){
        return ingredientService.getItems(ingredientId,model);
    }

    @GetMapping("/allIngredients")
    public String allIngredients(Model model){
        return ingredientService.allItems(model);
    }

    @GetMapping("/deleteIngredient")
    public String deleteIngredientForm(@RequestParam long ingredientId, Model model) {
        return ingredientService.deleteItemForm(ingredientId, model);
    }

    @DeleteMapping("/deleteIngredient")
    public String deleteIngredient(@RequestParam long ingredientId) {
        return ingredientService.deleteItem(ingredientId);
    }

    @GetMapping("/modifyIngredient")
    public String modifyIngredient(@RequestParam long ingredientId, Model model) {
        return ingredientService.modifyItem(ingredientId,model);
    }

    @PutMapping("/modifyIngredient")
    public String modifyIngredient(@RequestParam long ingredientId, @ModelAttribute Ingredient ingredient){
        return ingredientService.modifyItem(ingredientId, ingredient);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/newRecipe")
    public String newRecipeForm(Model model) {
        return recipeService.newItemForm(model);
    }

    @PostMapping("/newRecipe")
    public String newRecipe(@RequestParam long foodId, @RequestParam long ingredientId, Model model){
        return recipeService.newItem(foodId, ingredientId, model);
    }

    @GetMapping(path="getRecipe")
    public String getRecipe(@RequestParam long index, Model model){
        return recipeService.getItem(index,model);
    }

    @GetMapping("/allRecipes")
    public String allRecipes(Model model){
        return recipeService.allItems(model);
    }

    @GetMapping("/deleteRecipe")
    public String deleteRecipeForm(@RequestParam long index, Model model) {
        return recipeService.deleteItemForm(index, model);
    }

    @DeleteMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam long index) {
        return recipeService.deleteItem(index);
    }

    @GetMapping("/modifyRecipe")
    public String modifyRecipe(@RequestParam long index, Model model) {
        return recipeService.modifyItem(index,model);
    }

    @PutMapping("/modifyRecipe")
    public String modifyRecipe(@RequestParam long index, @RequestParam long foodId, @RequestParam long ingredientId){
        return recipeService.modifyItem(index, foodId, ingredientId);
    }
}