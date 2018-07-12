package com.sstgroup.petrolstation;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDetails extends ActionBarActivity{
    DBHelper mydb =new DBHelper(this);
    EditText idx;

    Button btnSearch;

    Button btnviewUpdate;


    EditText product;
    EditText station_location;
    EditText date;
    EditText time;
    EditText price;
    Button btn_saved;
    EditText quantity;
    private SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);


        product = (EditText) findViewById(R.id.product);
        station_location = (EditText) findViewById(R.id.station_location);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        price = (EditText) findViewById(R.id.price);
        quantity=(EditText) findViewById(R.id.quantity);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnSearch= (Button)findViewById(R.id.button_delete);
        idx=(EditText) findViewById(R.id.editText_id);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call search method.
                String prod=product.getText().toString();


                try {
                    String qt = mydb.getQuantity(prod);
                    String tm = mydb.getTime(prod);
                    String dt = mydb.getDate(prod);
                    String ltn = mydb.getLocation(prod);
                    String pr = mydb.getPrice(prod);
                    String id = mydb.getID(prod);

                    quantity.setText(qt);
                    price.setText(pr);
                    time.setText(tm);
                    date.setText(dt);
                    station_location.setText(ltn);
                    idx.setText(id);

                }catch(Exception ex){

                    ex.printStackTrace();

                }


            }
        });


        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = product.getText().toString().trim();
                String location = station_location.getText().toString().trim();
                String dt = date.getText().toString().trim();
                String tm =  time.getText().toString().trim();
                String prc = price.getText().toString().trim();
                String qt = quantity.getText().toString().trim();
                String product_id=idx.getText().toString().trim();
                // long product_id=Long.getLong(id);

                try{
                    mydb.updateProduct(product_id,name,location,dt,tm,prc,qt);
                    Toast.makeText(UpdateDetails.this,"Product Updated Successfully",Toast.LENGTH_LONG).show();
                }catch (Exception ex){

                }
            }
        });

    }




    public void btn_search(View view) {
        String name = product.getText().toString().trim();
        String location = station_location.getText().toString().trim();
        String dt = date.getText().toString().trim();
        String tm =  time.getText().toString().trim();
        String prc = price.getText().toString().trim();

        Person p = new Person();
        p.setStation_name(name);
        p.setStation_location(location);
        p.setDate(dt);
        p.setTime(tm);
        p.setPrice(prc);

        Toast.makeText(UpdateDetails.this,"Records Enterd Succesfully", Toast.LENGTH_LONG).show();

    }
}


