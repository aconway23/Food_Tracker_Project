package com.example.adam.foodtracker.models;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

/**
 * Created by adam on 20/11/2017.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodTracker.db";
    public static final String TABLE_NAME = "Food";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_MEAL_TYPE = "MealType";
    public static final String COLUMN_CONSUMED = "Consumed";
    public static final String COLUMN_DATE = "DATE";





    public FoodTrackerDatabase (Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + TABLE_NAME + " ( "
                + COLUMN_ID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MEAL_TYPE + " VARCHAR, "
                + COLUMN_CONSUMED + " VARCHAR, "
                + COLUMN_DATE + " TEXT);");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

//    public boolean addMealType(MealType mealType) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(mealType.BREAKFAST, mealType.getBREAKFAST());
//
//    }


    public void insertDataIntoTable(MealType meal, String consumed,  String date ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_CONSUMED, consumed);
        contentValues.put(COLUMN_DATE, date);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }


}





