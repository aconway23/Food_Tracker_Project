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

    public static MealType convertToMealType(String meal) {
        switch(meal) {
            case "Breakfast":
                return BREAKFAST;

            case "Lunch":
                return LUNCH;

            case "Dinner":
                return DINNER;

            case "Snack":
                return SNACKS;

            default:
                return null;

            }

        }
}
