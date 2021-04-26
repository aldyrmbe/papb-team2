package com.team2.foodrecipes.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    List<Favorite> getAllFavorites();

    @Insert
    void insertNewFavorite(Favorite favorite);

    @Delete
    void deleteFavorite(Favorite favorite);
}
