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

    @Query("SELECT kategori FROM recipe WHERE recipe_name = (:namaMasak)")
    String getKategori(String namaMasak);

    @Query("SELECT negara FROM recipe WHERE recipe_name = (:namaMasak)")
    String getNegara(String namaMasak);

    @Query("SELECT recipe_detail FROM recipe WHERE recipe_name = (:namaMasak)")
    String getDetail(String namaMasak);

    @Query("SELECT bahan FROM recipe WHERE recipe_name = (:namaMasak)")
    String getBahan(String namaMasak);

    @Query("SELECT uri FROM recipe WHERE recipe_name = (:namaMasak)")
    String getUri(String namaMasak);
}
