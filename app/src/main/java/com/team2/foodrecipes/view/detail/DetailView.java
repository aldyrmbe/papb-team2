package com.team2.foodrecipes.view.detail;

import com.team2.foodrecipes.model.Meals;

public interface DetailView {
    //TODO #4 Add void method  for showLoading, hideLoading, setMeal, onErrorLoading; (DONE)
    void showLoading();
    void hideLoading();
    void setMeals(Meals.Meal meal);
    void onErrorLoading(String message);
}
