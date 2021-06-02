package com.team2.foodrecipes.view.detail;

import com.team2.foodrecipes.model.Meals;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeals(Meals.Meal meal);
    void onErrorLoading(String message);
}
