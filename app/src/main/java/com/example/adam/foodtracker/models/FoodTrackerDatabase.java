package com.example.adam.foodtracker.models;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

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



    public void insertDataIntoTable(MealType meal, String consumed,  String date ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_CONSUMED, consumed);
        contentValues.put(COLUMN_DATE, date);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void updateDataInTable(String id, MealType meal, String consumed, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_CONSUMED, consumed);
        contentValues.put(COLUMN_DATE, date);
        db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[] {id});
        db.close();
    }

    public void deleteDataFromTable(String id, MealType meal, String consumed, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,COLUMN_ID + " = ?", new String[] {id});
        db.close();
    }

    public ArrayList<Food> getAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Food> foods = new ArrayList<Food>();
        Food food;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);

                String meal = cursor.getString(1);
                MealType mealType = MealType.convertToMealType(meal);

                String consume = cursor.getString(2);
                String date = cursor.getString(3);

                food = new Food(id, mealType, consume, date);
                foods.add(food);
            }
        }
        cursor.close();
        db.close();
        return foods;

    }




}





