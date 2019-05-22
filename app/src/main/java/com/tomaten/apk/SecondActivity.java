package com.tomaten.apk;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity  {

    public final String LOGTAG = "SecondActivity";
    public ArrayList<Product> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        final ListView listan = findViewById(R.id.listan);
        Bundle bundle = getIntent().getExtras();
        arrayList = (ArrayList<Product>) bundle.getSerializable("products");

        addFakeProduct();

        ArrayAdapter<Product> adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,
                arrayList);
        listan.setAdapter(adapter);

    }

    public void addFakeProduct(){
        Product p1 = new Product("Claes vin", "22", "55", "66", "99");

        try {
            arrayList.add(p1);
        }catch (NullPointerException e){
            Log.d(LOGTAG, "Error i SecondActivity.");
        }

    }

}


 /*
        ListView listan = findViewById(R.id.listan);
        List<String> list = new ArrayList<>();

        list.add("hej");
        list.add("på");
        list.add("dig");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        listan.setAdapter(adapter);
        */

