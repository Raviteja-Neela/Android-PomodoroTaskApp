package com.example.ravit.pomodorotaskapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class RemainderActivity extends AppCompatActivity {

    Button newRemainder;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);

        newRemainder=(Button)findViewById(R.id.newRemainder);

    }


}
