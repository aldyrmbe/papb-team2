package com.team2.foodrecipes.view.home;

import com.team2.foodrecipes.model.Categories;
import com.team2.foodrecipes.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
