package com.tomaten.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class CheckButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_button);

        gaVidare();
    }
    public void gaVidare(){
        final CheckBox checkBox20 = findViewById(R.id.checkBox20);
        final Button vidareBtn = findViewById(R.id.vidareBtn);
        //private final String LOGTAG = "CheckButtonActivity";

        //if(checkBox20.isChecked()){
            vidareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                if(checkBox20.isChecked()){
                    Intent myIntent = new Intent(CheckButtonActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }else{
                    Toast myToast = Toast.makeText(getApplicationContext(), "AJABAJA", Toast.LENGTH_SHORT);
                    myToast.show();
                    //Log.d(LOGTAG, "EEROOORLRÖLS");
                }
                }
            });

    }

}
/*
    public void gaVidare(){
        CheckBox checkBox20 = findViewById(R.id.checkBox20);
        Button vidareBtn = findViewById(R.id.vidareBtn);
        private final String LOGTAG = "CheckButtonActivity";

        if(checkBox20.isChecked()){
            vidareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(CheckButtonActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
            });
        }else{
            //Toast myToast = new Toast.makeText(CheckButtonActivity.this, "AJABAJA", Toast.LENGTH_SHORT);
            //myToast.show();
            Log.d(LOGTAG, "EEROOORLRÖLS");
        }

    }
 */
