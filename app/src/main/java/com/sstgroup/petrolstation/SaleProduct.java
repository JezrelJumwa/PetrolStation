package com.sstgroup.petrolstation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaleProduct extends ActionBarActivity{
    DBHelper mydb =new DBHelper(this);

    EditText idx;
    Button btnSearch;
    Button btnviewUpdate;
    EditText product;
    EditText price;
    EditText quantity;
    EditText newQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_product);


        product = (EditText) findViewById(R.id.product);

        price = (EditText) findViewById(R.id.price);
        quantity=(EditText) findViewById(R.id.quantity);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnSearch= (Button)findViewById(R.id.button_delete);
        idx=(EditText) findViewById(R.id.editText_id);
        newQuantity=(EditText) findViewById(R.id.newQuantityTxt);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call search method.

                if(product.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter the product",Toast.LENGTH_LONG).show();
                }
                String prod = product.getText().toString();
                try {
                    String qt = mydb.getQuantity(prod);
                    String pr = mydb.getPrice(prod);
                    String id = mydb.getID(prod);

                    quantity.setText(qt);
                    price.setText(pr);
                    idx.setText(id);

                } catch (Exception ex) {

                    ex.printStackTrace();

                }

            }
        });


        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(product.equals("") || price.equals("")||quantity.equals("")||idx.equals("")){
                    Toast.makeText(getApplicationContext(),"The Product is not available",Toast.LENGTH_LONG).show();
                }else {
                    try {
                        String newQ = newQuantity.getText().toString().trim();
                       // int nQ = Integer.getInteger(newQ);
                        double nQ=Double.parseDouble(newQ);

                        String newString = String.valueOf(nQ);

                        Toast.makeText(getApplicationContext(), newString, Toast.LENGTH_LONG).show();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }

                  String newQ = newQuantity.getText().toString().trim();
                  double nQ=Double.parseDouble(newQ);

                    // get product id and price
                    String p= price.getText().toString().trim();
                    double productPrice=Double.parseDouble(p);

                    String pid = idx.getText().toString().trim();

                    String oldQuantity=quantity.getText().toString().trim();
                    double oldQ=Double.parseDouble(oldQuantity);

                    if(nQ > oldQ ){
                        Toast.makeText(getApplicationContext(),"The quantity you are selling is large than what is in stock",Toast.LENGTH_LONG).show();
                    }else {
                        // sale product
                        try {
                            //update product table
                            double newQuantity = (oldQ - nQ);
                            String finalQuantity = String.valueOf(newQuantity);

                            mydb.updateQuantity(pid, finalQuantity);
                            double total = nQ * productPrice;

                            Toast.makeText(SaleProduct.this, "You have Sold product worth : Kshs. " + total + "\n Remaining Quantity is : " + newQuantity, Toast.LENGTH_LONG).show();


                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

    }


}


