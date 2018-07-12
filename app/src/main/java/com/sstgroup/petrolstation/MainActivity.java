package com.sstgroup.petrolstation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sstgroup.petrolstation.activities.UsersListActivity;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    DBHelper mydb;
    Button updateBtn;
    Button saleProduct;
    Button viewProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateBtn=(Button) findViewById(R.id.update_button);
        Button View = (Button)findViewById(R.id.viewusers);

        saleProduct=(Button) findViewById(R.id.saleproduct);
        viewProducts=(Button) findViewById(R.id.viewproducts);


        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllStation();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_list);

        saleProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), SaleProduct.class);
                startActivity(i);
            }
        });


        obj = (ListView) findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

//                Intent intent = new Intent(getApplicationContext(), DisplayDetails.class);
//
//                intent.putExtras(dataBundle);
//                startActivity(intent);

                Intent intent = new Intent(getApplicationContext(), DisplayDetails.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UpdateDetails.class);
                startActivity(intent);
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UsersListActivity.class));
            }
        });
        viewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DisplayDetails.class);
                startActivity(intent);
            }
        });

    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu
    ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.item1:
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Intent intent = new Intent(getApplicationContext(), EnterDetails.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                return true;

            case R.id.item2:
                Bundle dataBundle2 = new Bundle();
                dataBundle2.putInt("id", 0);
                Intent intent2 = new Intent(getApplicationContext(), DisplayDetails.class);
                intent2.putExtras(dataBundle2);
                startActivity(intent2);
                return true;

            case R.id.item3:
                Bundle dataBundle3 = new Bundle();
                dataBundle3.putInt("id", 0);
                Intent intent3 = new Intent(getApplicationContext(), UsersListActivity.class);
                intent3.putExtras(dataBundle3);
                startActivity(intent3);
                return true;

            case R.id.item4:
                Bundle dataBundle4 = new Bundle();
                dataBundle4.putInt("id", 0);
                Intent intent4 = new Intent(getApplicationContext(), SaleProduct.class);
                intent4.putExtras(dataBundle4);
                startActivity(intent4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}