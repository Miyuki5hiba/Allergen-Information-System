package com.allergen_info_service.Services;
import org.springframework.ui.Model;

public interface AllergenFoodService<T> {
    public abstract String home();

    public abstract String newItemForm(Model model);
    public abstract String newItem(T item, Model model);

    public abstract String modifyItem (long id, T item);
    public abstract String modifyItemForm (long id, Model model);

    public abstract String getItemForm(long id, Model model);
    public abstract T getItem(long id);

    public abstract String allItems(Model model);
    public abstract Iterable<T> getAllItems();

    public abstract String deleteItemForm(long id, Model model);
    public abstract String deleteItem(long id);   // Maybe change to boolean?
}
