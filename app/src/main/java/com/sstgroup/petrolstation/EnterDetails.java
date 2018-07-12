package com.sstgroup.petrolstation;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterDetails extends AppCompatActivity {
    DBHelper mydb =new DBHelper(this);

    EditText product;
    EditText station_location;
    EditText date;
    EditText time;
    EditText price;
    EditText quantity;
    Button btn_saved;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);


        product = (EditText) findViewById(R.id.station_name);
        station_location = (EditText) findViewById(R.id.station_location);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        price = (EditText) findViewById(R.id.price);
        quantity = (EditText) findViewById(R.id.quantity);

    }

    public void btn_saved(View view) {
        String name = product.getText().toString().trim();
        String location = station_location.getText().toString().trim();
        String dt = date.getText().toString().trim();
        String tm =  time.getText().toString().trim();
        String prc = price.getText().toString().trim();
        String qt = quantity.getText().toString().trim();

        if(name.equals("") || location.equals("") || dt.equals("") || tm.equals("") || prc.equals("")||qt.equals(""))
        {
            Toast.makeText(EnterDetails.this,"Please fill all fields", Toast.LENGTH_LONG).show();
        }else{

            Person p = new Person();
            p.setStation_name(name);
            p.setStation_location(location);
            p.setDate(dt);
            p.setTime(tm);
            p.setPrice(prc);
            p.setQuantity(qt);
            mydb.insertStation(p);

            Toast.makeText(EnterDetails.this,"Records Enterd Succesfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(EnterDetails.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}