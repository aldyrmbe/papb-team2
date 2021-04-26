package com.team2.foodrecipes.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Entity(tableName = "favorite")
@Data
@Builder
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

}
