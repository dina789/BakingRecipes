package com.example.dodo.bakingreceipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dodo.bakingreceipes.ActivityFragments.ReceipeDetailFragment;
import com.example.dodo.bakingreceipes.ActivityFragments.StepDetailFragment;
import com.example.dodo.bakingreceipes.Models.Receipe;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipeDetailActivity extends AppCompatActivity {
    // Track whether to display a two-pane or single-pane UI


    static String STACK_RECIPE_DETAIL = "STACK_RECIPE_DETAIL";
    static String STACK_RECIPE_STEP_DETAIL = "STACK_RECIPE_STEP_DETAIL";
    @BindView(R.id.tv_title_ingredients)
    TextView tv_title_ingredients;
    @BindView(R.id.tv_title_step)
    TextView tv_title_step;
    FrameLayout recipe_container_fragment;
    FrameLayout recipe_step_container;
    String recipeName;
    // A single-pane display refers to phone screens, and two-pane to larger tablet screens
    private boolean mTwoPane;
    private Receipe recipeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);


        FragmentManager fragmentManager = getSupportFragmentManager();

        recipeName = savedInstanceState.getString("Title");

        Bundle bundle = getIntent().getExtras();
        recipeModel = (Receipe) bundle.getSerializable("key");
        // Determine if you're creating a two-pane or single-pane display

        // to check which layout is going to be loaded?
//if tablet size check https://stackoverflow.com/questions/9279111/determine-if-the-device-is-a-smartphone-or-tablet
        if (findViewById(R.id.recipe_linear_layout) != null) {
            // This LinearLayout will only initially exist in the two-pane tablet case
            mTwoPane = true;
            if (savedInstanceState == null) {
                // Change the GridView to space out the images more on tablet
                // GridView gridView = (GridView) findViewById(R.id.images_grid_view);
                //   gridView.setNumColumns(2);

// In two-pane mode, add initial BodyPartFragments to the screen


                ReceipeDetailFragment DetailFragment = new ReceipeDetailFragment();


                DetailFragment.setArguments(bundle);


                fragmentManager.beginTransaction()
                        .replace(R.id.recipe_container_fragment, DetailFragment).addToBackStack(STACK_RECIPE_DETAIL)
                        .commit();

                // Create fragment instance for Step Details
                StepDetailFragment stepDetailFragment = new StepDetailFragment();


                fragmentManager.beginTransaction()
                        .replace(R.id.recipe_step_container, stepDetailFragment).addToBackStack(STACK_RECIPE_STEP_DETAIL)
                        .commit();

            } else {
                // We're in single-pane mode and displaying fragments on a phone in separate activities
                mTwoPane = false;


                ReceipeDetailFragment DetailFragment = new ReceipeDetailFragment();


                DetailFragment.setArguments(bundle);


                fragmentManager.beginTransaction()
                        .replace(R.id.recipe_container_fragment, DetailFragment).addToBackStack(STACK_RECIPE_DETAIL)
                        .commit();


            }

        }

    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();


        if (fm.getBackStackEntryCount() != 0) {
            //go back to "Recipe Detail" screen
            fm.popBackStack(STACK_RECIPE_DETAIL, 0);
            //   finish();
        } else {       //go back to "Recipe" screen
            startActivity(new Intent(this, ReceipeActivity.class));
            finish();
            // super.onBackPressed();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Title", recipeName);
    }


}


/**
 * using butterknife:
 * http://jakewharton.github.io/butterknife/
 * <p>
 * meaning of addtobackstack
 * https://stackoverflow.com/questions/22984950/what-is-the-meaning-of-addtobackstack-with-null-parameter
 * <p>
 * <p>
 * //OnBackPressed: https://stackoverflow.com/questions/26693754/fragment-addtobackstack-and-popbackstackimmediate-not-working*
 * //https://github.com/agungaprianto/Baking-app-revision/blob/master/app/src/main/java/id/developer/agungaprian/bakingapprevisi2/ui/ListDetailRecipeActivity.java
 * //https://stackoverflow.com/questions/27659038/addtobackstack-method-is-not-working-without-overriding-the-onbackpressed-me/27684596
 * //https://github.com/nikosvaggalis/Udacity-Advanced-Developer-Nanodegree-Baking-App-2017/blob/master/app/src/main/java/com/example/android/recipe/ui/RecipeDetailActivity.java
 */


//room
//https://github.com/tpakis/BakingApp/tree/master/app/src/main/java/com/scholarship/udacity/aithanasakis/bakingapp


//bundle information

//on clck launches next activity:



/*handling two pane mode:
//https://github.com/udacity/Android_Me/blob/TFragments.07-Solution-TwoPaneUI/app/src/main/java/com/example/android/android_me/ui/MainActivity.java#L67*/