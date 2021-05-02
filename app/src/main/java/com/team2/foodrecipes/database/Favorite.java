package com.team2.foodrecipes.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Entity(tableName = "favorite")
public class Favorite implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @ColumnInfo(name = "mealsName")
    private String mealsName;

    @ColumnInfo(name = "mealsCategory")
    private String mealsCategory;

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getMealsName() {
        return mealsName;
    }

    public String getMealsCategory() {
        return mealsCategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMealsName(String mealsName) {
        this.mealsName = mealsName;
    }

    public void setMealsCategory(String mealsCategory) {
        this.mealsCategory = mealsCategory;
    }
}
