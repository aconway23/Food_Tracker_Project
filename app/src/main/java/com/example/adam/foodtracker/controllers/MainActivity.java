package com.example.adam.foodtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.adam.foodtracker.R;
import com.example.adam.foodtracker.models.Food;
import com.example.adam.foodtracker.Database.FoodTrackerDatabase;
import com.example.adam.foodtracker.models.MealType;

public class MainActivity extends AppCompatActivity {
    FoodTrackerDatabase myDb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new FoodTrackerDatabase(this);

    }

    public void onMealButtonClick(View view) {
        Intent intent = new Intent(this, FoodActivity.class);
        Food food = new Food(1, MealType.BREAKFAST, "13/12/2017", "consumed" );
        String foodResult = food.getConsumed();
        intent.putExtra("result", foodResult);
        startActivity(intent);

    }

}
