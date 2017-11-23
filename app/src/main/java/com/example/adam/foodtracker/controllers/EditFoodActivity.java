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

public class EditFoodActivity extends AppCompatActivity {
    private TextView mealType, enterMeal, selectDate;
    private EditText editFoodTwo, editDateTwo;
    private Button saveMealButtonTwo;
    private Button deleteMealButton;
    FoodTrackerDatabase myDb;
    Spinner mealDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);
        myDb = new FoodTrackerDatabase(this);

        this.mealDropdown = findViewById(R.id.mealSpinner2);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Snacks"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mealDropdown.setAdapter(adapter);

        this.mealType = findViewById(R.id.mealTypeTextTwo);
        this.enterMeal = findViewById(R.id.enterMealTextTwo);
        this.selectDate = findViewById(R.id.selectDateTextTwo);
        this.editFoodTwo = findViewById(R.id.editFoodTwo);
        this.editDateTwo = findViewById(R.id.editDateTwo);
        this.deleteMealButton = findViewById(R.id.deleteMealButton);

    }

    public void onSaveMealButtonTwoClick(View Button) {
        String meal = (String) this.mealDropdown.getSelectedItem();
        String food = this.editFoodTwo.getText().toString();
        String date = this.editDateTwo.getText().toString();

        myDb.insertDataIntoTable(MealType.convertToMealType(meal), food, date);
        finish();
    }
}
