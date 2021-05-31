package com.team2.foodrecipes.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipe")
    List<Recipe> getAllRecipes();

    @Insert
    void insertRecipe(Recipe... recipes);

    @Delete
    void delete(Recipe recipe);
}
