package com.example.dodo.bakingreceipes.Models;

import java.io.Serializable;
import java.util.List;

public class Receipe implements Serializable {

    private int id;
    private String name;
    private List<Ingredients> ingredients;
    private List<StepsOfReceipes> steps;
    private int servings;
    private String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public List<StepsOfReceipes> getSteps() {
        return steps;
    }

    public int getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }
}
