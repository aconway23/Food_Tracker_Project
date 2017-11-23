package com.example.adam.foodtracker.models;

import java.io.Serializable;

/**
 * Created by adam on 20/11/2017.
 */

public class Food implements Serializable{


    private int id;
    private MealType meal;
    private String date;
    private String consumed;


    public Food(int id, MealType meal, String date, String consumed) {
        this.id = id;
        this.meal = meal;
        this.date = date;
        this.consumed = consumed;
    }



    public int getId() {
        return id;
    }

    public MealType getMealType() {
        return this.meal;
    }


    public String getDate() {
        return date;
    }


    public String getConsumed() {
        return this.consumed;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setMealType(MealType meal) {
        this.meal = meal;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setConsumed(String consumed) {
        this.consumed = consumed;
    }
}
