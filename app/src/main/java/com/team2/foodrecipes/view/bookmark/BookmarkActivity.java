package com.team2.foodrecipes.view.bookmark;


import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team2.foodrecipes.R;
import com.team2.foodrecipes.db.AppDatabase;
import com.team2.foodrecipes.db.Recipe;

import java.util.List;

public class BookmarkActivity extends AppCompatActivity {

    private RecipeListAdapter recipeListAdapter;

    private ImageView bookmarkImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark);

        Button addNewRecipeButton = findViewById(R.id.addNewRecipeButton);
        addNewRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, AddNewRecipeActivity.class);

               startActivityForResult(intent, 100);
            }
        });

        initRecyclerView();

        loadRecipeList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recipeListAdapter = new RecipeListAdapter(this);
        recyclerView.setAdapter(recipeListAdapter);
    }

    private void  loadRecipeList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Recipe> recipeList = db.recipeDao().getAllRecipes();
        recipeListAdapter.setRecipeList(recipeList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadRecipeList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
