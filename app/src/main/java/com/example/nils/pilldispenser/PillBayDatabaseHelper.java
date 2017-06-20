package com.example.nils.pilldispenser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PillBayDatabaseHelper extends SQLiteOpenHelper {
    /**
     * A column for each piece of data is created.
     */
    public static final String DATABASE_NAME = "pilldb.db";
    public static final String TABLE_ITEMS = "pillbays";
    public static final String COL_1 = "number";
    public static final String COL_2 = "name";
    public static final String COL_3 = "quantity";

    private static PillBayDatabaseHelper sInstance;


    public static synchronized PillBayDatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PillBayDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * A new DatabaseHelper object is created from a given context.
     * @param context The given context.
     */
    public PillBayDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * This method is called when a DatabaseHelper object is constructed.
     * The table is generated from each of the initialized columns.
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_ITEMS + " (" + COL_1 + " TEXT," + COL_2 + " TEXT," + COL_3 + " TEXT" + ");");
    }

    /**
     * This method is called when the database table is upgraded.
     * @param db The database.
     * @param oldVersion The old version number of the table.
     * @param newVersion The new version number of the table.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    /**
     * This method adds an item to the full item list data table.
     * Each piece of data of an item is put into a separate row.
     * @param item The new item.
     */
    public void addElement(ListElement item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, item.getNumber());
        values.put(COL_2, item.getName());
        values.put(COL_3, item.getQuantity());
        db.insert(TABLE_ITEMS, null, values);
        db.close(); // Closing database connection
    }

    /**
     * This method returns an ArrayList of all of the items stored in the full list table.
     * @return The ArrayList of items.
     */
    public ArrayList<ListElement> getAllElements() {
        ArrayList<ListElement> itemlist = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ListElement item = new ListElement();
                item.setNumber(Integer.parseInt(cursor.getString(0)));
                item.setName(cursor.getString(1));
                item.setQuantity(Integer.parseInt(cursor.getString(2)));
                // Adding item to list
                itemlist.add(item);
            } while (cursor.moveToNext());
        }
        // return item list
        return itemlist;
    }

    /**
     * This method clears the full item list database.
     */
    public void clearDatabase(String TABLE_ITEM) {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM " + "pillbays";
        db.execSQL(clearDBQuery);
    }


}

