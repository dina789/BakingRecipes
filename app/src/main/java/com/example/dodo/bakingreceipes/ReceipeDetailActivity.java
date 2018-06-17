package com.example.dodo.bakingreceipes;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dodo.bakingreceipes.ActivityFragments.ReceipeDetailFragment;
import com.example.dodo.bakingreceipes.ActivityFragments.RecipeIngredientFragment;
import com.example.dodo.bakingreceipes.ActivityFragments.StepDetailFragment;
import com.example.dodo.bakingreceipes.Models.Ingredients;
import com.example.dodo.bakingreceipes.Models.Receipe;
import com.example.dodo.bakingreceipes.Models.StepsOfReceipes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ReceipeDetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_title_ingredients)
    TextView tv_title_ingredients;
    @BindView(R.id.tv_title_step) TextView tv_title_step;
    FrameLayout recipe_container_fragment;
    private Receipe recipeModel;
    private boolean mTwoPane;
    private Unbinder unbinder;
    private ArrayList<Receipe> recipe;
    String recipeName;
    private StepsOfReceipes stepsModel;
    private boolean RecipeSelected = true;
    static String STACK_RECIPE_DETAIL="STACK_RECIPE_DETAIL";
    static String STACK_RECIPE_STEP_DETAIL="STACK_RECIPE_STEP_DETAIL";
    public static List<Ingredients> ingredientsModelList = new ArrayList<Ingredients>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe_detail);
        ButterKnife.bind(this);

        //retrieve the bundle of information from receipe activity:
        if (savedInstanceState == null) {
            // savedInstanceState is non-null when there is fragment state
            // saved from previous configurations of this activity
            // (e.g. when rotating the screen from portrait to landscape).
            // In this case, the fragment will automatically be re-added
            // to its container so we don't need to manually add it.
            Bundle bundle = getIntent().getExtras();
            recipeModel = (Receipe) bundle.getSerializable("key");
            tv_title_ingredients.setText(recipeModel.getName());

            // Creating a new head fragment

            final ReceipeDetailFragment DetailFragment = new ReceipeDetailFragment();
            DetailFragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.recipe_container_fragment, DetailFragment).addToBackStack(STACK_RECIPE_DETAIL)
                    .commit();

            // to check which layout is going to be loaded?
//if tablet size check https://stackoverflow.com/questions/9279111/determine-if-the-device-is-a-smartphone-or-tablet
            if (findViewById(R.id.recipe_linear_layout).getTag() != null && findViewById(R.id.recipe_linear_layout).getTag().equals("tablet-land")) {

                final StepDetailFragment fragment2 = new StepDetailFragment();
                fragment2.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.recipe_step_container, fragment2).addToBackStack(null)
                        .commit();

            } else {
                recipeName = savedInstanceState.getString("Title");
            }
        }


        @Override
        public void onBackPressed() {
                FragmentManager fm = getSupportFragmentManager();


            if (fm.getBackStackEntryCount() != 0){
                //go back to "Recipe Detail" screen
                fm .popBackStack(STACK_RECIPE_DETAIL, 0);
             //   finish();
            } else
            {       //go back to "Recipe" screen

                super.onBackPressed();
            }




@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle bundle = new Bundle();
        bundle.putSerializable("ser", stepsModelSave);
        bundle.putBoolean("bol", mIngredientSelected);
        outState.putBundle("bun", bundle);
    }

    @Override
    public void onIngredientItemClicked(List<IngredientsModel> ingredientsModelList) {
        if (mTwoPane) {
        //detail container el fel tablettttt
          RecipeSelected = true;
           ReceipeDetailFragment DetailFragment = new   ReceipeDetailFragment ();
                 DetailFragment.setRecipe(recipe);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container,  DetailFragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, ReceipeDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("key", (Serializable) receipe);
            intent.putExtra(Intent.EXTRA_TEXT, bundle);
            startActivity(intent);
        }
    }

    @Override
    public void onStepItemClicked(StepsOfReceipes stepsModel) {
        if (mTwoPane) {

          RecipeSelected = false;
            StepDetailFragment stepDetailFragment = new StepDetailFragment();
            stepDetailFragment.setStepsModel(stepsModel);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, stepDetailFragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, StepDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("ser", stepsModel);
            intent.putExtra(Intent.EXTRA_TEXT, bundle);
            startActivity(intent);
        } }
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}



/**
 * using butterknife:
 * http://jakewharton.github.io/butterknife/
 *
 *meaning of addtobackstack
 * https://stackoverflow.com/questions/22984950/what-is-the-meaning-of-addtobackstack-with-null-parameter
 *
 *
 * //OnBackPressed: https://stackoverflow.com/questions/26693754/fragment-addtobackstack-and-popbackstackimmediate-not-working*
 //https://github.com/agungaprianto/Baking-app-revision/blob/master/app/src/main/java/id/developer/agungaprian/bakingapprevisi2/ui/ListDetailRecipeActivity.java
 //https://stackoverflow.com/questions/27659038/addtobackstack-method-is-not-working-without-overriding-the-onbackpressed-me/27684596
 //https://github.com/nikosvaggalis/Udacity-Advanced-Developer-Nanodegree-Baking-App-2017/blob/master/app/src/main/java/com/example/android/recipe/ui/RecipeDetailActivity.java

 *
 */


//room
//https://github.com/tpakis/BakingApp/tree/master/app/src/main/java/com/scholarship/udacity/aithanasakis/bakingapp
