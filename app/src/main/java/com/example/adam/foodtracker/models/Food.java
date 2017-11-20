package com.example.adam.foodtracker.models;

/**
 * Created by adam on 20/11/2017.
 */

public class Food {

    private int id;
    private String date;
    private MealType meal;
    //    private String day;
//    private String time;



    public Food(MealType meal) {
        this.meal = meal;
        this.id = id;
        this.date = date;


//        this.day = day;
//        this.time = time;

    }

    public MealType getMealType() {
        return this.meal;
    }



}
