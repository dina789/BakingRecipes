package com.example.dodo.bakingreceipes;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.example.dodo.bakingreceipes.ActivityFragments.ReceipeDetailFragment;
import com.example.dodo.bakingreceipes.ActivityFragments.StepDetailFragment;
import com.example.dodo.bakingreceipes.Models.Receipe;

import java.util.ArrayList;

import butterknife.ButterKnife;

import static com.example.dodo.bakingreceipes.ReceipeDetailActivity.STACK_RECIPE_DETAIL;
import static com.example.dodo.bakingreceipes.ReceipeDetailActivity.STACK_RECIPE_STEP_DETAIL;

public class RecipeDetailActivity extends AppCompatActivity {
    // Track whether to display a two-pane or single-pane UI
    // A single-pane display refers to phone screens, and two-pane to larger tablet screens
    private boolean mTwoPane;
    FrameLayout recipe_container_fragment;

    FrameLayout recipe_step_container;
    String recipeName;
    private Receipe recipeModel;
    static String STACK_RECIPE_DETAIL="STACK_RECIPE_DETAIL";
    static String STACK_RECIPE_STEP_DETAIL="STACK_RECIPE_STEP_DETAIL";

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


        if (fm.getBackStackEntryCount() != 0){
            //go back to "Recipe Detail" screen
            fm .popBackStack(STACK_RECIPE_DETAIL, 0);
            //   finish();
        } else
        {       //go back to "Recipe" screen
            startActivity(new Intent(this, ReceipeActivity.class));
            finish();
           // super.onBackPressed();
        }

}

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Title",recipeName);
    }






}






    //bundle information

    //on clck launches next activity:



/*handling two pane mode:
//https://github.com/udacity/Android_Me/blob/TFragments.07-Solution-TwoPaneUI/app/src/main/java/com/example/android/android_me/ui/MainActivity.java#L67