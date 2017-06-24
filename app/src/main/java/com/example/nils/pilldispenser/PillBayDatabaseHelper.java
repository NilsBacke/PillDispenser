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
    public static final String DATABASE_NAME = "pills.db";

    public static final String TABLE_ITEMS = "pillbay";
    public static final String TABLE_SUN_MORN = "sundaymorning";
    public static final String TABLE_SUN_AFT = "sundayafternoon";
    public static final String TABLE_SUN_EVE = "sundayevening";
    public static final String TABLE_SUN_NIGHT = "sundaynight";
    public static final String TABLE_MON_MORN = "mondaymorning";
    public static final String TABLE_MON_AFT = "mondayafternoon";
    public static final String TABLE_MON_EVE= "mondayevening";
    public static final String TABLE_MON_NIGHT = "mondaynight";
    public static final String TABLE_TUES_MORN = "tuesdaymorning";
    public static final String TABLE_TUES_AFT = "tuesdayafternoon";
    public static final String TABLE_TUES_EVE = "tuesdayevening";
    public static final String TABLE_TUES_NIGHT = "tuesdaynight";
    public static final String TABLE_WED_MORN = "wednesdaymorning";
    public static final String TABLE_WED_AFT = "wednesdayafternoon";
    public static final String TABLE_WED_EVE = "wednesdayevening";
    public static final String TABLE_WED_NIGHT = "wednesdaynight";
    public static final String TABLE_THURS_MORN = "thursdaymorning";
    public static final String TABLE_THURS_AFT = "thursdayafternoon";
    public static final String TABLE_THURS_EVE = "thursdayevening";
    public static final String TABLE_THURS_NIGHT = "thursdaynight";
    public static final String TABLE_FRI_MORN = "fridaymorning";
    public static final String TABLE_FRI_AFT = "fridayafternoon";
    public static final String TABLE_FRI_EVE = "fridayevening";
    public static final String TABLE_FRI_NIGHT = "fridaynight";
    public static final String TABLE_SAT_MORN = "saturdaymorning";
    public static final String TABLE_SAT_AFT = "saturdayafternoon";
    public static final String TABLE_SAT_EVE = "saturdayevening";
    public static final String TABLE_SAT_NIGHT = "saturdaynight";

    public static final String COL_1 = "number";
    public static final String COL_2 = "name";
    public static final String COL_3 = "quantity";

    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE " + TABLE_ITEMS + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SUN_MORN = "CREATE TABLE " + TABLE_SUN_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SUN_AFT = "CREATE TABLE " + TABLE_SUN_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SUN_EVE = "CREATE TABLE " + TABLE_SUN_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SUN_NIGHT = "CREATE TABLE " + TABLE_SUN_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_MON_MORN = "CREATE TABLE " + TABLE_MON_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_MON_AFT = "CREATE TABLE " + TABLE_MON_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_MON_EVE = "CREATE TABLE " + TABLE_MON_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_MON_NIGHT = "CREATE TABLE " + TABLE_MON_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";

    private static final String CREATE_TABLE_TUES_MORN = "CREATE TABLE " + TABLE_TUES_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";

    private static final String CREATE_TABLE_TUES_AFT = "CREATE TABLE " + TABLE_TUES_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";

    private static final String CREATE_TABLE_TUES_EVE = "CREATE TABLE " + TABLE_TUES_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";

    private static final String CREATE_TABLE_TUES_NIGHT = "CREATE TABLE " + TABLE_TUES_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_WED_MORN = "CREATE TABLE " + TABLE_WED_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_WED_AFT = "CREATE TABLE " + TABLE_WED_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_WED_EVE = "CREATE TABLE " + TABLE_WED_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_WED_NIGHT = "CREATE TABLE " + TABLE_WED_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_THURS_MORN = "CREATE TABLE " + TABLE_THURS_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_THURS_AFT = "CREATE TABLE " + TABLE_THURS_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_THURS_EVE = "CREATE TABLE " + TABLE_THURS_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_THURS_NIGHT = "CREATE TABLE " + TABLE_THURS_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_FRI_MORN = "CREATE TABLE " + TABLE_FRI_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_FRI_AFT = "CREATE TABLE " + TABLE_FRI_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_FRI_EVE = "CREATE TABLE " + TABLE_FRI_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_FRI_NIGHT = "CREATE TABLE " + TABLE_FRI_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SAT_MORN = "CREATE TABLE " + TABLE_SAT_MORN + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SAT_AFT = "CREATE TABLE " + TABLE_SAT_AFT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SAT_EVE = "CREATE TABLE " + TABLE_SAT_EVE + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";
    private static final String CREATE_TABLE_SAT_NIGHT = "CREATE TABLE " + TABLE_SAT_NIGHT + " (" + COL_1 + " TEXT," + COL_2 +
            " TEXT," + COL_3 + " TEXT" + ");";

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
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_TABLE_SUN_MORN);
        db.execSQL(CREATE_TABLE_SUN_AFT);
        db.execSQL(CREATE_TABLE_SUN_EVE);
        db.execSQL(CREATE_TABLE_SUN_NIGHT);
        db.execSQL(CREATE_TABLE_MON_MORN);
        db.execSQL(CREATE_TABLE_MON_AFT);
        db.execSQL(CREATE_TABLE_MON_EVE);
        db.execSQL(CREATE_TABLE_MON_NIGHT);
        db.execSQL(CREATE_TABLE_TUES_MORN);
        db.execSQL(CREATE_TABLE_TUES_AFT);
        db.execSQL(CREATE_TABLE_TUES_EVE);
        db.execSQL(CREATE_TABLE_TUES_NIGHT);
        db.execSQL(CREATE_TABLE_WED_MORN);
        db.execSQL(CREATE_TABLE_WED_AFT);
        db.execSQL(CREATE_TABLE_WED_EVE);
        db.execSQL(CREATE_TABLE_WED_NIGHT);
        db.execSQL(CREATE_TABLE_THURS_MORN);
        db.execSQL(CREATE_TABLE_THURS_AFT);
        db.execSQL(CREATE_TABLE_THURS_EVE);
        db.execSQL(CREATE_TABLE_THURS_NIGHT);
        db.execSQL(CREATE_TABLE_FRI_MORN);
        db.execSQL(CREATE_TABLE_FRI_AFT);
        db.execSQL(CREATE_TABLE_FRI_EVE);
        db.execSQL(CREATE_TABLE_FRI_NIGHT);
        db.execSQL(CREATE_TABLE_SAT_MORN);
        db.execSQL(CREATE_TABLE_SAT_AFT);
        db.execSQL(CREATE_TABLE_SAT_EVE);
        db.execSQL(CREATE_TABLE_SAT_NIGHT);
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUN_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUN_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUN_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUN_NIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MON_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MON_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MON_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MON_NIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUES_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUES_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUES_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUES_NIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WED_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WED_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WED_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WED_NIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THURS_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THURS_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THURS_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THURS_NIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRI_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRI_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRI_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRI_NIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAT_MORN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAT_AFT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAT_EVE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAT_NIGHT);
        onCreate(db);
        //push
    }

    /**
     * This method adds an item to the full item list data table.
     * Each piece of data of an item is put into a separate row.
     * @param item The new item.
     */
    public void addElement(String tableName, ListElement item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, item.getNumber());
        values.put(COL_2, item.getName());
        values.put(COL_3, item.getQuantity());
        db.insert(tableName, null, values);
        db.close(); // Closing database connection
    }

//    public void changeQuantity(String tableName, int quantity) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_3, quantity);
//        return db.update(tableName, values, KEY_ID + " = ?", null);
//    }

    /**
     * This method returns an ArrayList of all of the items stored in the full list table.
     * @return The ArrayList of items.
     */
    public ArrayList<ListElement> getAllElements(String tableName) {
        ArrayList<ListElement> itemlist = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + tableName;
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
    public void clearDatabase(String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM " + tableName;
        db.execSQL(clearDBQuery);
    }


}

