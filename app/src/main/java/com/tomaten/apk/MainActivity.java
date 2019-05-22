package com.tomaten.apk;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class MainActivity extends AppCompatActivity {

    //TODO Sidemenu
    //TODO hålla inne på listobjekt för mer info
    //TODO listan sparas efter nerstängd - SharedPrefecenc()?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count();

        clear();

        goToSecondView();

        addToList();
    }

    public void count(){

        final EditText volym = findViewById(R.id.volym);
        final EditText pris = findViewById(R.id.pris);
        final EditText alkoholprocent = findViewById(R.id.alkoholprocent);
        final EditText apk = findViewById(R.id.apk);

        Button rakna = findViewById(R.id.rakna);

        rakna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volym.getText().toString().trim().isEmpty() || pris.getText().toString().trim().isEmpty() || alkoholprocent.getText().toString().trim().isEmpty()){

                    Toast alert = Toast.makeText(MainActivity.this, "Skriv i alla rutorna dumbo.", Toast.LENGTH_SHORT);
                    alert.show();
                }else{

                    double vol = Double.parseDouble(String.valueOf(volym.getText()));
                    double pri = Double.parseDouble(String.valueOf(pris.getText()));
                    double pro = Double.parseDouble(String.valueOf(alkoholprocent.getText()));

                    double total = (vol * pro) / pri;

                    apk.setText(String.valueOf(total / 10));
                }
            }
        });
    }


    public void clear(){

        final EditText namn = findViewById(R.id.namn);
        final EditText volym = findViewById(R.id.volym);
        final EditText pris = findViewById(R.id.pris);
        final EditText alkoholprocent = findViewById(R.id.alkoholprocent);
        final EditText apk = findViewById(R.id.apk);

        Button clear = findViewById(R.id.clear);

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!namn.getText().toString().trim().isEmpty() || !volym.getText().toString().trim().isEmpty() || !pris.getText().toString().trim().isEmpty() || !alkoholprocent.getText().toString().trim().isEmpty() ){

                        namn.setText("");
                        volym.setText("");
                        pris.setText("");
                        alkoholprocent.setText("");
                        apk.setText("");
                    }else {

                        Toast alert = Toast.makeText(MainActivity.this, "Rutorna är redan tomma.", Toast.LENGTH_SHORT);
                        alert.show();
                    }
                }
            });

    }

    public void goToSecondView(){

        Button goSecond = findViewById(R.id.secondactivity);



        goSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getBaseContext(), SecondActivity.class);
                //Måste vara "Serializable" annars kraschar kukfan
                myIntent.putExtra("products", (Serializable) arrayList);
                startActivity(myIntent);
            }
        });
    }

    final List<Product> arrayList = new ArrayList<>();

    public void addToList(){

        final EditText volym = findViewById(R.id.volym);
        final EditText pris = findViewById(R.id.pris);
        final EditText alkoholprocent = findViewById(R.id.alkoholprocent);
        final EditText apk = findViewById(R.id.apk);
        final EditText namn = findViewById(R.id.namn);

        Button add = findViewById(R.id.addtolist);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Pressed button add");

                String nam = namn.getText().toString();
                String vol = volym.getText().toString();
                String pri = pris.getText().toString();
                String alko = alkoholprocent.getText().toString();
                String ap = apk.getText().toString();


                if(volym.getText().toString().trim().isEmpty() || pris.getText().toString().trim().isEmpty() || alkoholprocent.getText().toString().trim().isEmpty() || apk.getText().toString().trim().isEmpty()) {

                    Toast fyllIRutornaAlert = Toast.makeText(MainActivity.this, "Fyll i alla rutorna.", Toast.LENGTH_SHORT);
                    fyllIRutornaAlert.show();
                }else{

                    if (nam.isEmpty()) {
                        Product p = new Product(vol, pri, alko, ap);
                        arrayList.add(p);
                    } else {
                        Product p = new Product(nam, vol, pri, alko, ap);
                        arrayList.add(p);
                    }

                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                    myIntent.putExtra("products", (Serializable) arrayList);
                    //startActivity(myIntent);
                    Toast tillagdAlert = Toast.makeText(MainActivity.this, "Tillagd i listan.", Toast.LENGTH_SHORT);
                    tillagdAlert.show();
                }
            }
        });
    }

}

