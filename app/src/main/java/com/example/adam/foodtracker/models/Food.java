package com.example.adam.foodtracker.models;

/**
 * Created by adam on 20/11/2017.
 */

public class Food {

    private int id;
    private MealType meal;
    private String date;


    //private String day;
//    private String time;



    public Food(int id, MealType meal, String date) {
        this.id = id;
        this.meal = meal;
        this.date = date;


//        this.day = day;
//        this.time = time;

    }

    public MealType getMealType() {
        return this.meal;
    }


    public String getDate() {
        return date;
    }


    public int getId() {
        return id;
    }
}
