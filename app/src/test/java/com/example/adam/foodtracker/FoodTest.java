package com.example.adam.foodtracker;

import com.example.adam.foodtracker.models.Food;
import com.example.adam.foodtracker.models.MealType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adam on 20/11/2017.
 */

public class FoodTest {

    Food food;

    @Test
    public void testReturnFoodType() {
        food = new Food(MealType.BREAKFAST);
        assertEquals(MealType.BREAKFAST, food.getMealType());


    }
}
