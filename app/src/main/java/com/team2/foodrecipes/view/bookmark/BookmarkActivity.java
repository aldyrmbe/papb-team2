package com.team2.foodrecipes.view.bookmark;


import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team2.foodrecipes.R;
import com.team2.foodrecipes.db.AppDatabase;
import com.team2.foodrecipes.db.Recipe;
import com.team2.foodrecipes.view.detail.DetailActivity;
import com.team2.foodrecipes.view.home.HomeActivity;

import java.util.List;

public class BookmarkActivity extends AppCompatActivity {

    private RecipeListAdapter recipeListAdapter;

    private ImageView bookmarkImage;
    AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark);

        // tombol untuk input resep
        Button addNewRecipeButton = findViewById(R.id.addNewRecipeButton);
        addNewRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, AddNewRecipeActivity.class);

               startActivityForResult(intent, 100);
            }
        });

        // inisialiasasi recyclerview
        initRecyclerView();

        // muat resep dari database ke recyclerview
        loadRecipeList();

        // masuk ke detail resep
        recipeListAdapter.setOnItemClickListener((view, position) -> {
            TextView mealName = view.findViewById(R.id.mealName);
            String namaMasak = mealName.getText().toString();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("namaMasak", namaMasak);
            startActivity(intent);
        });

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recipeListAdapter = new RecipeListAdapter(this);

        // inisialisasi fungsi swipe untuk delete resep
        // swipe ke kanan atau kiri sepenuhnya untuk menghapus resep dari database
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Recipe recipe = recipeListAdapter.getRecipe(position);
                db.recipeDao().delete(recipe);
                loadRecipeList();
                recipeListAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);

        recipeListAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(recipeListAdapter);
    }

    private void  loadRecipeList() {
        db = AppDatabase.getDbInstance(this.getApplicationContext());
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
