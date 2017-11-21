package com.example.adam.foodtracker;

import com.example.adam.foodtracker.models.Food;
import com.example.adam.foodtracker.models.MealType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adam on 20/11/2017.
 */

public class FoodTest {

    Food food;
    MealType mealType;

    @Before
    public void before() {
        food = new Food(1, MealType.BREAKFAST, "20/11/17", "Porridge" );
        mealType = MealType.BREAKFAST;
    }


    @Test
    public void testReturnFoodType() {
//        food = new Food(MealType.BREAKFAST);
        assertEquals(MealType.BREAKFAST, food.getMealType());
    }

    @Test
    public void testReturnFoodFromEnum() {
        assertEquals("Breakfast", mealType.getMeal());
    }


    @Test
    public void testCanGetDate() {
        assertEquals("20/11/17", food.getDate());
    }


    @Test
    public void testCanGetId() {
        assertEquals(1, food.getId());
    }

    @Test
    public void testCanGetFoodConsumed() {
        assertEquals("Porridge", food.getConsumed());
    }
}
