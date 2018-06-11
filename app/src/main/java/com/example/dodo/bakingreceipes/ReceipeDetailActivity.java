package com.example.dodo.bakingreceipes;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dodo.bakingreceipes.Models.Receipe;

public class ReceipeDetailActivity extends AppCompatActivity {

    private Receipe recipeModel;
    private boolean mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        recipeModel = (RecipeModel) bundle.getSerializable("key");
        mTwoPane = false;
        titleTextView.setText(recipeModel.getName());
        getSupportActionBar().setTitle(recipeModel.getName());

        //retrieve the bundle of information from receipe activity:
        //and set the correct index for all receipes.
        FragmentManager fragmentManager = getSupportFragmentManager();

        RecipeIngredientFragment ingredientFragment = new RecipeIngredientFragment();
        ingredientFragment.setIngredientsModelList(recipeModel.getIngredients());

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.recipe_ingredient_container, ingredientFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.recipe_ingredient_container, ingredientFragment)
                    .commit();
        }

        RecipeStepFragment stepFragment = new RecipeStepFragment();
        stepFragment.setStepsModelList(recipeModel.getSteps());

        fragmentManager.beginTransaction()
                .add(R.id.recipe_step_container, stepFragment)
                .commit();

    }
}
