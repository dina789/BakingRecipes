package com.example.dodo.bakingreceipes.ActivityFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.dodo.bakingreceipes.Adapters.ReceipeAdapter;
import com.example.dodo.bakingreceipes.Models.Receipe;
import com.example.dodo.bakingreceipes.R;
import com.example.dodo.bakingreceipes.ReceipeActivity;


public class ReceipeFragment extends Fragment
{

    public interface RecipeListener {
        void onRecipeClicked(Receipe recipeModel);
        void showErrorSnackBar();
    }
//empty constructor for initializing fragment
   public ReceipeFragment()
   {
    }


     //Inflate fragment layout and sets recycler view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     //inflate baking app fragment layout:
        View rootView = inflater.inflate(R.layout.recipe_fragment_body_parts, container, false);

         RecyclerView Recycler_Recipe=(RecyclerView) rootView.findViewById(R.id.Recycler_Recipe);

         ReceipeAdapter recipesAdapter =new ReceipeAdapter((ReceipeActivity)getActivity());

         Recycler_Recipe.setAdapter(recipesAdapter);


     return rootView;
// i need to check which layout is going to be loaded?
        if (rootView.findViewById(R.id.check_view) != null)
            Recycler_Recipe.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2, GridLayoutManager.VERTICAL, false));
        else
            Recycler_Recipe.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));

        Recycler_Recipe.setHasFixedSize(true);
        Recycler_Recipe.setAdapter(recipesAdapter);









    }





}

/*
on fragments layout :
https://developer.android.com/training/basics/fragments/creating
https://discussions.udacity.com/t/can-someone-please-post-a-screenshot-of-the-baking-app/439712/6

notes:
**define a place in the activity main for the fragment to go --Fragment container.
* static frag:
master list fragment will not change during actiivty runtime i can use fragment layout
bundle is a set of key values pairs
 */

//https://stackoverflow.com/questions/15313598/once-for-all-how-to-correctly-save-instance-state-of-fragments-in-back-stack/17135346#17135346
//https://github.com/AKBwebdev/BakingApp/blob/master/app/src/main/java/com/example/android/bakingapp/fragments/RecipeListFragment.java