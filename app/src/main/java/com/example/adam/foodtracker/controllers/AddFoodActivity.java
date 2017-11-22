package com.example.adam.foodtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adam.foodtracker.Database.FoodTrackerDatabase;
import com.example.adam.foodtracker.R;
import com.example.adam.foodtracker.models.MealType;

public class AddFoodActivity extends AppCompatActivity {
    private TextView mealType, enterMealText, selectDateText;
    private EditText editFood, editDate;
    private Button saveMealButton;
    FoodTrackerDatabase myDb;
     Spinner mealDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        myDb = new FoodTrackerDatabase(this);

        this.mealDropdown = (Spinner) findViewById(R.id.mealSpinner);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Snacks"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mealDropdown.setAdapter(adapter);

        this.mealType = findViewById(R.id.mealTypeText);
        this.enterMealText = findViewById(R.id.enterMealText);
        this.selectDateText = findViewById(R.id.selectDateText);

        this.editDate = findViewById(R.id.editDate);
        this.editFood = findViewById(R.id.editFood);
    }

    public void onSaveMealButtonClick(View Button) {
        String meal = (String) this.mealDropdown.getSelectedItem();
        String food = this.editFood.getText().toString();
        String date = this.editDate.getText().toString();

        myDb.insertDataIntoTable(MealType.convertToMealType(meal), food, date);
        finish();
    }


}
