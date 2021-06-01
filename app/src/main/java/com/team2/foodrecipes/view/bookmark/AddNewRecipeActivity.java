/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 4/29/21 8:58 PM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2021. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.team2.foodrecipes.view.bookmark;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.team2.foodrecipes.R;
import com.team2.foodrecipes.db.AppDatabase;
import com.team2.foodrecipes.db.Recipe;

public class AddNewRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        EditText recipeNameInput = findViewById(R.id.recipeNameInput);
        EditText detailInput = findViewById(R.id.detailInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewRecipe(recipeNameInput.getText().toString(), detailInput.getText().toString());
            }
        });

    }

    private void saveNewRecipe (String recipeName, String detail) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        Recipe recipe = new Recipe();
        recipe.recipeName = recipeName;
        recipe.recipeDetail = detail;
        db.recipeDao().insertRecipe(recipe);

        finish();
    }
}
