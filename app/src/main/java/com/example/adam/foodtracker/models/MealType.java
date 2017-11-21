package com.example.adam.foodtracker.models;

/**
 * Created by adam on 20/11/2017.
 */

public enum MealType {

    BREAKFAST ("Breakfast"),
    LUNCH ("Lunch"),
    DINNER ("Dinner"),
    SNACKS ("Snacks");

    private final String meal;

    MealType(String meal) {
        this.meal = meal;
    }

    public String getMeal() {
        return this.meal;
    }
}
