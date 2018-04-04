package me.duydev.lab04;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RestaurantHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "lab008.db";
    private static final int SCHEMA_VER = 1;

    public RestaurantHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE restaurants( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert( String name, String address, String type ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("type", type);
        getWritableDatabase().insert("restaurants", "name", contentValues);
    }

    public Cursor getAll(){
        return getReadableDatabase().rawQuery("SELECT _id, name, address, type FROM restaurants ORDER BY name", null);
    }

    public String getName(Cursor c) {
        return c.getString(1);
    }

    public String getAddress(Cursor c) {
        return c.getString(2);
    }

    public String getType(Cursor c) {
        return c.getString(3);
    }

}
