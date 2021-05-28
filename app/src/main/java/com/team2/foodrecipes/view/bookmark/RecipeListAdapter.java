
package com.team2.foodrecipes.view.bookmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team2.foodrecipes.R;
import com.team2.foodrecipes.db.Recipe;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {

    private Context context;
    private List<Recipe> recipeList;

    public RecipeListAdapter(Context context){
        this.context = context;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecipeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.MyViewHolder holder, int position) {
        holder.tvRecipeName.setText(this.recipeList.get(position).recipeName);
        holder.tvRecipeDetail.setText(this.recipeList.get(position).recipeDetail);
    }

    @Override
    public int getItemCount() {
        return this.recipeList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tvRecipeName;
        TextView tvRecipeDetail;
        public MyViewHolder(View view){
            super(view);
            tvRecipeName = view.findViewById(R.id.tvRecipeName);
            tvRecipeDetail = view.findViewById(R.id.tvRecipeDetail);

        }
    }
}
