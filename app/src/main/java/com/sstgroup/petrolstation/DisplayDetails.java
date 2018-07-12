package com.sstgroup.petrolstation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DBHelper database_area;
        SQLiteDatabase db;
        Cursor c;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        try

        {

            db = openOrCreateDatabase("MyDBStations.db", 1, null);
            c = db.rawQuery("SELECT * FROM stations ", null);
            TextView v = (TextView) findViewById(R.id.displayinfo);
            c.moveToFirst();

            String temp = "";
            while (!c.isAfterLast())

            {

                String s1 = c.getString(1);
                String s2 = c.getString(2);
                String s3 = c.getString(3);
                String s4 = c.getString(4);
                String s5 = c.getString(5);
                String s6 = c.getString(6);

                temp = temp + "\nProduct: " + s1 + "\nStation Location: " + s2 + "\nTime: " + s3 + "\nPrice: " + s4 + "\nDate: " + s5 + "\nQuantity: " + s6 +"\n\n\n\n";
                c.moveToNext();

            }

            v.setText(temp);

        } catch (SQLiteException e)

        {

        }
    }

}
