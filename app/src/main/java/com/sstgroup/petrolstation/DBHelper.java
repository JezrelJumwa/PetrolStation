package com.sstgroup.petrolstation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDBStations.db";
    public static final String STATION_TABLE_NAME = "stations";
    public static final String STATION_COLUMN_ID = "id";
    public static final String STATION_COLUMN_NAME = "product";
    public static final String STATION_COLUMN_LOCATION = "station_location";
    public static final String STATION_COLUMN_Date = "date";
    public static final String STATION_COLUMN_Start_Time = "time";
    public static final String STATION_COLUMN_Price = "price";
    public static final String STATION_COLUMN_Quantity = "quantity";

    SQLiteDatabase db;

    public static final String CREATE_TABLE = "create table stations " +
            "(id primary key,product text, station_location text,time text,price text, date text,quantity text)";

    public static final String CREATE_TABLE_SALES = "create table sales " +
            "(id primary key,product_name text, quantity text,price text)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS stations");
        onCreate(db);
    }

    public void insertStation (Person p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String query = "SELECT * FROM stations";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        contentValues.put(STATION_COLUMN_ID, count);
        contentValues.put(STATION_COLUMN_NAME,p.product);
        contentValues.put(STATION_COLUMN_LOCATION,p.station_location);
        contentValues.put(STATION_COLUMN_Date,p.date);
        contentValues.put(STATION_COLUMN_Start_Time,p.time);
        contentValues.put(STATION_COLUMN_Price,p.price);
        contentValues.put(STATION_COLUMN_Quantity,p.quantity);
        db.insert("stations", null, contentValues);
    }

    public Person list_me(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM stations",null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1) +""+cursor.getString(2) +""+cursor.getString(3) +""+cursor.getString(4) +""+cursor.getString(5) +""+cursor.getString(6));
        }
        return null;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, STATION_TABLE_NAME);
        return numRows;
    }

    public boolean updateProduct(String product_id, String name, String location, String dt, String tm, String prc , String qt)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("product", name);
        contentValues.put("station_location", location);
        contentValues.put("date", dt);
        contentValues.put("time", tm);
        contentValues.put("price", prc);
        contentValues.put("quantity", qt);
        db.update("stations", contentValues, "id ="+product_id,null);
        return true;
    }

    public boolean updateQuantity(String pid, String finalQuantity)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("quantity", finalQuantity);
        db.update("stations", contentValues, "id ="+pid,null);
        return true;
    }

    public Integer deleteStation(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("stations",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<String> getAllStation() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(STATION_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    public Cursor getinfo(SQLiteDatabase db) {
        Cursor cursor;
        String[] projetc = {STATION_COLUMN_NAME, STATION_COLUMN_LOCATION, STATION_COLUMN_Date, STATION_COLUMN_Start_Time, STATION_COLUMN_Price, STATION_COLUMN_Quantity};
        cursor = db.query(STATION_TABLE_NAME, projetc, null, null, null, null, null, null);
        return cursor;
    }

    //get product
    public String getQuantity(String product) {
        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations WHERE product='"+product+"'", null);

        if (res!=null) {
            res.moveToFirst();
            result=res.getString((res.getColumnIndex(STATION_COLUMN_Quantity)));
            return result;
        }
        return null;
    }
    //get location
    public String getLocation(String product) {
        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations WHERE product='"+product+"'", null);

        if (res!=null) {
            res.moveToFirst();
            result=res.getString((res.getColumnIndex(STATION_COLUMN_LOCATION)));
            return result;
        }
        return null;
    }
    //get price
    public String getPrice(String product) {
        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations WHERE product='"+product+"'", null);

        if (res!=null) {
            res.moveToFirst();
            result=res.getString((res.getColumnIndex(STATION_COLUMN_Price)));
            return result;
        }
        return null;
    }
    //get date
    public String getDate(String product) {
        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations WHERE product='"+product+"'", null);

        if (res!=null) {
            res.moveToFirst();
            result=res.getString((res.getColumnIndex(STATION_COLUMN_Date)));
            return result;
        }
        return null;
    }

    //get time
    public String getTime(String product) {
        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations WHERE product='"+product+"'", null);

        if (res!=null) {
            res.moveToFirst();
            result=res.getString((res.getColumnIndex(STATION_COLUMN_Start_Time)));
            return result;
        }
        return null;
    }

    //get id
    public String getID(String product) {
        String result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations WHERE product='"+product+"'", null);

        if (res!=null) {
            res.moveToFirst();
            result=res.getString((res.getColumnIndex(STATION_COLUMN_ID)));
            return result;
        }
        return null;
    }


    public ArrayList<String> getProduct() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from stations", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(STATION_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

}