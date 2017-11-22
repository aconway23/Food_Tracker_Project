package com.example.adam.foodtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adam.foodtracker.Database.FoodTrackerDatabase;
import com.example.adam.foodtracker.R;
import com.example.adam.foodtracker.models.Food;
import com.example.adam.foodtracker.models.FoodTrackerAdapter;
import com.example.adam.foodtracker.models.MealType;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    FoodTrackerDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        myDb = new FoodTrackerDatabase(this);





        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String foodResult = extras.getString("result");

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Food> food = myDb.getAllRecords();

        FoodTrackerAdapter foodAdapter =  new FoodTrackerAdapter(this, food);

        ListView listView = findViewById(R.id.foodList);

        listView.setAdapter(foodAdapter);
    }

    public void onAddMealButtonClick(View view) {
        Intent intent = new Intent(this, AddFoodActivity.class);
        startActivity(intent);
    }
}
