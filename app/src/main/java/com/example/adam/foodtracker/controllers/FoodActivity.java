package com.example.adam.foodtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adam.foodtracker.R;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String foodResult = extras.getString("result");

    }
}
