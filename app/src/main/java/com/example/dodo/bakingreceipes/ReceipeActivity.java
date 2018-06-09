package com.example.dodo.bakingreceipes;


import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.dodo.bakingreceipes.ActivityFragments.ReceipeFragment;
import com.example.dodo.bakingreceipes.Adapters.ReceipeAdapter;
import com.example.dodo.bakingreceipes.Models.Receipe;

import java.util.ArrayList;

public class ReceipeActivity extends AppCompatActivity  implements ReceipeFragment.RecipeListener

{

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipe_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        getSupportActionBar().setHomeButtonEnabled(false);

        getSupportActionBar().setTitle("Baking App");
        //use a fragment manager and transaction to add the fragment to screeen (adds fragment to specifed container)

        if (savedInstanceState == null) {

            // using a fragment transaction.

            //create a new bodyparts fragment instance and display it using fragment manager:
            ReceipeFragment headfragment = new ReceipeFragment();

            //fragment transaction
            getSupportFragmentManager().beginTransaction().add(R.id.recipe_fragment_body_part_container, headfragment).commit();
        }

    }

    private void setSupportActionBar(Toolbar toolbar) {

    }










    @Override
    public void onRecipeClicked(Receipe recipeModel) {
        //bundle it up and attach it to a new activity that launches receipe detail activity

        Bundle bundle = new Bundle();
        bundle.putSerializable("key", recipeModel);
        Intent intent = new Intent(this, ReceipeDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }







    @Override
    public void showErrorSnackBar() {

    }
//connectivity network info
    }
















/**
 *passing  serializable list using Bundle.Serializable:
 *https://stackoverflow.com/questions/14333449/passing-data-through-intent-using-serializable
 *
 *static and dynamic fragment:
 * https://stackoverflow.com/questions/23664906/static-fragments-vs-dynamic-fragments
 *
 *setting cardview and recycler view:
 * https://www.androidhive.info/2016/05/android-working-with-card-view-and-recycler-view/
 *
 *
 * This way you’ll be able to send data between activities, and then from Activity to Fragment:
 * https://discussions.udacity.com/t/baking-app-help/775556
 *https://stackoverflow.com/questions/7149802/how-to-transfer-some-data-to-another-fragment
 *
 * on how to use on saved instance:
 * https://stackoverflow.com/questions/6525698/how-to-use-onsavedinstancestate-example-please
 *
 *
 *https://github.com/AbduallahAtta/BakingApp/tree/master/app/src/main/res/layout
 *https://github.com/matewiszt/AnnasBakery/blob/master/app/src/main/java/com/example/android/annasbakery/activity/DetailActivity.java
 *https://github.com/AKBwebdev/BakingApp/tree/master/app/src/main/java/com/example/android/bakingapp/network
 * https://developer.android.com/training/implementing-navigation/descendant#java
 * https://github.com/DimitriKatsoulis/Udacity_BakingApp/tree/master/app/src/main
 https://github.com/ddeleon92/BakingApp/tree/master/app/src/main/java/com/example/daou5____/mybakingapp
 https://github.com/dnKaratzas/udacity-baking-recipes/tree/master/app/src/main/java/eu/dkaratzas/bakingrecipes

 for json data:: https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json

important review on retrofit :
 https://github.com/diamondCollector/BakingApp
 https://discussions.udacity.com/t/retrofit-loading-intial-list-of-recipes/725377/7

 for implementation reference:
 http://www.i-programmer.info/professional-programmer/accreditation/10908-insiders-guide-to-udacity-android-developer-nanodegree-part-3-the-making-of-baking-app.html

 */

//note or consider that
// RecipeFragment won't be changing during the runtime of its host RecipeActivity,
     //   we can consider it a Static Fragment,
   //     which means that we can treat it and load it as a simple design time layout like every other.
