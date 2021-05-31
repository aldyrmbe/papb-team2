package com.team2.foodrecipes.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "recipe_name")
    public String recipeName;

    @ColumnInfo(name = "recipe_detail")
    public String recipeDetail;

}
