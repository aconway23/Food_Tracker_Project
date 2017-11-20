package com.example.adam.foodtracker.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adam on 20/11/2017.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodTracker.db";
    public static final String TABLE_NAME = "Food";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_BREAKFAST = MealType.BREAKFAST.name();
    public static final String COLUMN_LUNCH = MealType.LUNCH.name();
    public static final String COLUMN_DINNER = MealType.DINNER.name();
    public static final String COLUMN_SNACKS = MealType.SNACKS.name();



    public FoodTrackerDatabase (Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " " +
                "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_BREAKFAST + " VARCHAR, " + COLUMN_LUNCH +
                " VARCHAR, " + COLUMN_DINNER + " VARCHAR, " + COLUMN_SNACKS + " VARCHAR);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
