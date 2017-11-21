package com.example.adam.foodtracker.controllers;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.adam.foodtracker.R;
import com.example.adam.foodtracker.models.Food;

public class MainActivity extends AppCompatActivity {

    ImageButton mealButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealButton = findViewById(R.id.mealButton);
    }

//    public void onMealButtonClick(View view) {
//        Intent intent = new Intent(this, FoodActivity.class);
//        Food food = new Food("Breakfast");
//
//
//    }

}
