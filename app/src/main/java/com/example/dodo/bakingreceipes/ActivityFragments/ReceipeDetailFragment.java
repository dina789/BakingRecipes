package com.example.dodo.bakingreceipes.ActivityFragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dodo.bakingreceipes.R;

public class ReceipeDetailFragment extends AppCompatActivity {


    private Bundle arguments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe_detail_fragment);
    }


    public void setArguments(Bundle arguments) {


        this.arguments = arguments;
    }
}


//https://github.com/MoaazElneshawy/BakingApp/blob/master/app/src/main/java/com/example/moaazfathy/bakingapp/Activities/RecipeDetailsActivity.java