package com.example.ravit.pomodorotaskapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Logic for home screen of the app

public class HomeActivity extends AppCompatActivity {

    public TextView textView;
    public Button focusNow, setRemainder, goals;
    //public String focus_time, sbreak_time, lbreak_time;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=(TextView)findViewById(R.id.textView);
        focusNow=(Button)findViewById(R.id.focusNow);
        goals=(Button)findViewById(R.id.settings);
        //setRemainder=(Button)findViewById(R.id.setRemainder);


        /*setRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(HomeActivity.this, RemainderActivity.class);
                startActivity(i1);
            }
        });*/

        focusNow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i2= new Intent(HomeActivity.this, MainActivity.class);
                startActivity(i2);

            }
        });



        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(HomeActivity.this, GoalActivity.class);
                //startActivity(i3);
                startActivityForResult(i3,0);
            }
        });
    }


}
