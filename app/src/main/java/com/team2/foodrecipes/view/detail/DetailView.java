/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/7/19 5:49 PM                                               -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.team2.foodrecipes.view.detail;

import com.team2.foodrecipes.model.Meals;

public interface DetailView {
    //TODO #4 Add void method  for showLoading, hideLoading, setMeal, onErrorLoading; (DONE)
    void showLoading();
    void hideLoading();
    void setMeals(Meals.Meal meal);
    void onErrorLoading(String message);
}
