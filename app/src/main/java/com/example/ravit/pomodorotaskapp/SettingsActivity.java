package com.example.ravit.pomodorotaskapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends  AppCompatActivity{

    ArrayAdapter<CharSequence> adapter1,adapter2,adapter3;
    Spinner sbreak,lbreak,focused;
    String focused_val,sbreak_val,lbreak_val;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_settings);


        PrefFragment prefFragment = new PrefFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, prefFragment);
        fragmentTransaction.commit();


        /**focused = (Spinner)findViewById(R.id.focused);

        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter1 = ArrayAdapter.createFromResource(this,
                R.array.focused_values, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        focused.setAdapter(adapter1);

        sbreak = (Spinner)findViewById(R.id.sbreak);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter2 = ArrayAdapter.createFromResource(this,
                R.array.sbreak_values, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sbreak.setAdapter(adapter2);

        lbreak = (Spinner)findViewById(R.id.lbreak);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter3 = ArrayAdapter.createFromResource(this,
                R.array.lbreak_values, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        lbreak.setAdapter(adapter3);


        focused.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (adapterView.getItemAtPosition(position).equals("15 mins")) {
                    focused_val = adapterView.getItemAtPosition(position).toString();
                }
                else
                {

                    focused_val = adapterView.getItemAtPosition(position).toString();
                    passValues();
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sbreak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {


                    if (adapterView.getItemAtPosition(position).equals("05 mins")) {
                        sbreak_val = adapterView.getItemAtPosition(position).toString();
                    }
                    else
                    {

                        sbreak_val = adapterView.getItemAtPosition(position).toString();
                        passValues();
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lbreak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (adapterView.getItemAtPosition(position).equals("15 mins")) {
                    lbreak_val = adapterView.getItemAtPosition(position).toString();
                }
                else
                {

                    lbreak_val = adapterView.getItemAtPosition(position).toString();
                    passValues();
                }            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


            }

    public void passValues(){
        Intent i=new Intent(SettingsActivity.this,MainActivity.class);
        i.putExtra("focused",focused_val);
        System.out.println(focused_val);
        i.putExtra("sbreak",sbreak_val);
        System.out.println(sbreak_val);
        i.putExtra("lbreak",lbreak_val);
        System.out.println(lbreak_val);
        startActivity(i);

    }
*/
    }

}
