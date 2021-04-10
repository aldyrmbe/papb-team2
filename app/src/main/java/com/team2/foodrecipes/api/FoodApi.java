package com.team2.foodrecipes.api;

import com.team2.foodrecipes.model.Categories;
import com.team2.foodrecipes.model.Meals;

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

    //TODO #3 Call the search.php with query string the meal name (DONE)
    @GET("search.php")
    Call<Meals> getMealByName(@Query("s") String mealName);
}
