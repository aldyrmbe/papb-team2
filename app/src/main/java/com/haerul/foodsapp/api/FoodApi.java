/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.api;

import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {

    @GET("random.php")

    Call<Meals> getMeal();

    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php")
    Call<Meals> getMealByCategory(@Query("c") String category);

    //TODO #3 Call the search.php with query string the meal name @GET("search.php) (DONE)
    @GET("search.php")
    Call<Meals> getMealByName(@Query("name") String mealName);
}
