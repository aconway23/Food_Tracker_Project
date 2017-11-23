package com.example.adam.foodtracker.controllers;

import android.content.Intent;
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
import com.example.adam.foodtracker.models.Food;
import com.example.adam.foodtracker.models.MealType;

public class EditFoodActivity extends AppCompatActivity {
    private TextView mealType, enterMeal, selectDate;
    private EditText editFoodTwo, editDateTwo;
    private Button saveMealButtonTwo;
    private Button deleteMealButton;
    private String foodID;
    FoodTrackerDatabase myDb;
    Spinner mealDropdown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);
        myDb = new FoodTrackerDatabase(this);

        this.mealType = findViewById(R.id.mealTypeTextTwo);
        this.enterMeal = findViewById(R.id.enterMealTextTwo);
        this.selectDate = findViewById(R.id.selectDateTextTwo);
        this.editFoodTwo = findViewById(R.id.editFoodTwo);
        this.editDateTwo = findViewById(R.id.editDateTwo);
        this.deleteMealButton = findViewById(R.id.deleteMealButton);
        this.saveMealButtonTwo = findViewById(R.id.saveMealButtonTwo);

        this.mealDropdown = findViewById(R.id.mealSpinner2);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Snacks"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mealDropdown.setAdapter(adapter);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Food food = (Food) extras.getSerializable("Food");

        this.editFoodTwo.setText(food.getConsumed());
        this.editDateTwo.setText(food.getDate());
        foodID = String.valueOf(food.getId());
        String mealType = food.getMealType().getMeal();

        for(int i = 0; i < items.length; i++) {
            if(items[i].equals(mealType)) {
                this.mealDropdown.setSelection(i);
                break;
            }
        }


        // *Hamish note for loop*
        //the above for loop will loop through items array
        //if the item equals my saved food meal type
        //then that id is the id of the selection which
        //will be used to populate the correct item on the spinner

    }

    public void onSaveMealButtonTwoClick(View button) {
        String meal = (String) this.mealDropdown.getSelectedItem();
        String food = this.editFoodTwo.getText().toString();
        String date = this.editDateTwo.getText().toString();

        myDb.updateDataInTable(foodID, MealType.convertToMealType(meal), food, date);
        finish();
    }


    public void onDeleteMealButtonClicked(View button) {
        myDb.deleteDataFromTable(foodID);
        finish();

    }


}
