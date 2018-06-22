package com.example.dodo.bakingreceipes.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dodo.bakingreceipes.Models.Receipe;
import com.example.dodo.bakingreceipes.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.RecipeViewHolder> {


        private RecipeListOnClickHandler mOnClickHandler;
        private Context mContext;
        private ArrayList<Receipe> mRecipeList;



    public void setRecipeData(ArrayList<Receipe> recipeList) {
        mRecipeList = recipeList;
        notifyDataSetChanged();
    }
    /**
     * The interface that receives onClick messages.
     */

public interface RecipeListOnClickHandler {

    void onClick(Receipe recipe);
}

    /**
     *  The on-click handler for this adapter. This single handler is called when an item is clicked.
     *
     */
    public ReceipeAdapter(RecipeListOnClickHandler onClickHandler) {
        mOnClickHandler = onClickHandler;
    }






    @Override
    public ReceipeAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new RecipeViewHolder(view);



    }


    @Override
    public void onBindViewHolder(ReceipeAdapter.RecipeViewHolder holder, int position)
    {

        if (position < getItemCount()) {
            Receipe recipe=  mRecipeList.get(position);

            String recipeName = recipe.getName();
            String imageUrl= recipe.getImage();


            if (imageUrl!="") {
                Uri builtUri = Uri.parse(imageUrl).buildUpon().build();
                Picasso.with(mContext).load(builtUri).into(holder.imageRecyclerView);

        }
    }}
        @Override
        public int getItemCount() { if

            ( mRecipeList== null){
        return -1;
    }
        return mRecipeList.size();
    }




    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.imageview_recipe_icon)
    ImageView imageViewRecipeIcon;
    @BindView(R.id.textview_recipe_name)
    TextView textViewRecipeName;


    public RecipeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    /**
     * This method gets called when child view is clicked
     */
    @Override
    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();

        Receipe recipe = mRecipeList.get(adapterPosition);
        mOnClickHandler.onClick(recipe);

    }
}

    /**
     * Method used by RecyclerView to list the recipes
     */




    /**
     * Method used to refresh the list once the adapter is already created, to avoid creating a new one
     */


    }

//https://github.com/tpakis/BakingApp/blob/master/app/src/main/java/com/scholarship/udacity/aithanasakis/bakingapp/adapter/RecipesMainAdapter.java