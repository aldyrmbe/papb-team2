
package com.team2.foodrecipes.view.bookmark;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team2.foodrecipes.R;
import com.team2.foodrecipes.db.Recipe;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {

    private Context context;
    private List<Recipe> recipeList;
    private static ClickListener clickListener;


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
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_meal, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.MyViewHolder holder, int position) {
        holder.tvRecipeName.setText(this.recipeList.get(position).recipeName);
        //load default image
        holder.imagePre.setImageResource(R.drawable.sample_image_meal);
        //holder.tvRecipeDetail.setText(this.recipeList.get(position).recipeDetail);
    }

    @Override
    public int getItemCount() {
        return this.recipeList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvRecipeName;
        TextView tvRecipeDetail;
        ImageView imagePre;
        public MyViewHolder(View view){
            super(view);
            tvRecipeName = view.findViewById(R.id.mealName);
            //tvRecipeDetail = view.findViewById(R.id.tvRecipeDetail);
            imagePre = view.findViewById(R.id.mealThumb);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view,getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ClickListener clickListener){
        RecipeListAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }

    public Recipe getRecipe (int position){
        return this.recipeList.get(position);
    }
}
