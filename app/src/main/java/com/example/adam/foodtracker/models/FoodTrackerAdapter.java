package com.example.adam.foodtracker.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adam.foodtracker.R;

import java.util.ArrayList;

/**
 * Created by adam on 22/11/2017.
 */

public class FoodTrackerAdapter extends ArrayAdapter<Food>{
    public FoodTrackerAdapter(Context context, ArrayList<Food> food) {
        super(context, 0, food);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_food, parent, false);
        }

        Food currentFoodItem = getItem(position);

        TextView type = listItemView.findViewById(R.id.breakfastText);
        type.setText(currentFoodItem.getMealType().getMeal());

        TextView consumed = listItemView.findViewById(R.id.consumedText);
        consumed.setText(currentFoodItem.getConsumed().toString());

        TextView date = listItemView.findViewById(R.id.dateText);
        date.setText((currentFoodItem.getDate().toString()));

        listItemView.setTag(currentFoodItem);

        return listItemView;
    }
}
