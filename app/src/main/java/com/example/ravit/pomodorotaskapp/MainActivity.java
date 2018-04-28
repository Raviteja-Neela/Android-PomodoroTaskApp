package com.example.ravit.pomodorotaskapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public TextView msg;
    public TextView time1;
    private TextView what;
    EditText what1,status;
    public String taskstatus;
    public ImageButton work,break1,lbreak1,play;
    private Button settings;
    public  TextView sbreaktv,lbreaktv,focustv;
    SharedPreferences sharedPreferences,sharedPreferences1;
    public String prefList1,prefList2,prefList3,prefList4,worktime;
    private int success_block=0,sbreak_block=0,lbreak_block=0;
    public String focus_time, sbreak_time, lbreak_time,timer,intent_msg;
    private Boolean timer_cb_val,work_flag = false,sbreak_flag = false,lbreak_flag = false;
    private static final String DATABASENAME ="timer.db";
    private static final int DATABASEVERSION = 1;
    public String today,txt,block_hours;


    //private CountDownTimer countDownTimer;
   //public boolean check=false,check1=false,check2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        focustv = (TextView) findViewById(R.id.focustv);
        sbreaktv = (TextView) findViewById(R.id.sbreaktv);
        lbreaktv = (TextView) findViewById(R.id.lbreaktv);
        settings = (Button) findViewById(R.id.settings);
        msg = (TextView) findViewById(R.id.textView);
        what= (TextView)findViewById(R.id.what);

        time1 = (TextView) findViewById(R.id.textView1);
        work = (ImageButton) findViewById(R.id.imageButton1);
        work.setTag(R.drawable.laptop);

        break1 = (ImageButton) findViewById(R.id.imageButton2);
        break1.setTag(R.drawable.coffee);

        lbreak1 = (ImageButton) findViewById(R.id.imageButton3);
        lbreak1.setTag(R.drawable.break1);

        play = (ImageButton) findViewById(R.id.imageButton0);
        play.setTag(R.drawable.play1);

        play.setEnabled(false);



        Log.i("Default value 555",time1.getText().toString());

        //String currentDate = DateFormat.getDateInstance( ).format(Calendar.getInstance().getTime());
        //String currentDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(Calendar.getInstance().getTime());
        Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         today = formatter.format(date);
      //  System.out.println("Today : " + today);


        Log.i("Date val",today);

        what.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("1000","Entered textview listener");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Set Tag");
                what1= new EditText(MainActivity.this);
                builder.setMessage("Enter the tag for the work");
                builder.setView(what1);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txt = what1.getText().toString();
                        what.setText(txt);

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog ad=builder.create();
                ad.show();
            }
        });

        sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        prefList1 = sharedPreferences1.getString("PREF_FOCUS", "no selection");
        prefList2 = sharedPreferences1.getString("PREF_SBREAK", "no selection");
        prefList3 = sharedPreferences1.getString("PREF_LBREAK", "no selection");
        prefList4 = sharedPreferences1.getString("PREF_BLOCK","no selection");



        focus_time = prefList1.toString() + " mins";

        sbreak_time = prefList2.toString() + " mins";

        lbreak_time = prefList3.toString() + " mins";

        block_hours = prefList4.toString();

        focustv.setText(focus_time);
        sbreaktv.setText(sbreak_time);
        lbreaktv.setText(lbreak_time);

        //success_block = getIntent().getExtras().getInt("block");
        //Toast.makeText(getApplicationContext(),"Completed"+ success_block+ "succesfully",Toast.LENGTH_LONG).show();

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                play.setEnabled(true);
                Log.i("333", "Button clicked perfectly");
                int tag = (int) work.getTag();
                Log.i("444", "Got tag");
                //Log.i("555",prefList1.toString());
                if (tag == R.drawable.laptop) {
                    work.setBackgroundResource(R.drawable.laptopb);
                    break1.setBackgroundResource(R.drawable.coffee);

                    work_flag=true;
                    sbreak_flag=false;
                    lbreak_flag=false;
                    Log.i("999",""+work_flag);
                    lbreak1.setBackgroundResource(R.drawable.break1);
                    what.setText("Set Tag");
                    work.setTag(R.drawable.laptopb);
                    msg.setText("Start focused work");
                    prefList1 = sharedPreferences1.getString("PREF_FOCUS", "no selection");
                    time1.setText(prefList1.toString() + ":00");
                    timer=prefList1.toString();
                    intent_msg="work";
               }
               else {
                    work.setBackgroundResource(R.drawable.laptop);
                    work.setTag(R.drawable.laptop);
                    work_flag=false;

                }

            }
        });//End of work button

        /*play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tag0 = (int) play.getTag();
                if (tag0 == R.drawable.play1) {
                    play.setBackgroundResource(R.drawable.stop1);
                    play.setTag(R.drawable.stop1);
                    //start();
                }
                else {
                    play.setBackgroundResource(R.drawable.play1);
                    play.setTag(R.drawable.play1);
                    //cancel();
                }

            }
        });//End of play button
*/
        play.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        Log.i("Default value",time1.getText().toString());
                                        /*if(time1.getText().toString() == "00:00") {

                                            Toast.makeText(getApplicationContext(),"To start timer, Select either Work | Short Break | Long Break",Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                            finish();

                                        }
                                        else
                                        {
                                            Intent timeractivity = new Intent(MainActivity.this, TimerActivity.class);
                                            timeractivity.putExtra("ClockVal", timer);
                                            timeractivity.putExtra("IntentMsg", intent_msg);
                                            startActivityForResult(timeractivity, 1);
                                        }*/

                                        Intent timeractivity = new Intent(MainActivity.this, TimerActivity.class);
                                        timeractivity.putExtra("ClockVal", timer);
                                        timeractivity.putExtra("IntentMsg", intent_msg);
                                        startActivityForResult(timeractivity, 1);


                                    }
                                });

        break1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                play.setEnabled(true);
                int tag1 = (int) break1.getTag();
                if (tag1 == R.drawable.coffee) {
                    break1.setBackgroundResource(R.drawable.coffeeb);
                    lbreak1.setBackgroundResource(R.drawable.break1);
                    work.setBackgroundResource(R.drawable.laptop);
                    work_flag=false;
                    sbreak_flag=true;
                    lbreak_flag=false;
                    what.setText("Break");
                    break1.setTag(R.drawable.coffeeb);
                    msg.setText("Start short break");
                    //time1.setText("05:00");
                    time1.setText(prefList2.toString() + ":00");
                    timer=prefList2.toString();
                    intent_msg="sbreak";

                } else {
                    break1.setBackgroundResource(R.drawable.coffee);
                    break1.setTag(R.drawable.coffee);
                    sbreak_flag=false;
                }

            }
        });

        lbreak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                play.setEnabled(true);
                int tag2 = (int) lbreak1.getTag();
                if (tag2 == R.drawable.break1) {
                    msg.setText("Start long break");
                    lbreak1.setBackgroundResource(R.drawable.breakb);
                    work.setBackgroundResource(R.drawable.laptop);
                    break1.setBackgroundResource(R.drawable.coffee);
                    lbreak1.setTag(R.drawable.breakb);
                    sbreak_flag=false;
                    work_flag=false;
                    lbreak_flag=true;
                    what.setText("Long Break");
                    //time1.setText("30:00");
                    time1.setText(prefList3.toString() + ":00");
                    timer=prefList3.toString();
                    intent_msg="lbreak";
                }
                else {
                    lbreak1.setBackgroundResource(R.drawable.break1);
                    lbreak1.setTag(R.drawable.break1);
                    lbreak_flag=false;
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(i3, 0);
            }
        });

    }


  /*  private void start() {
        int minutes = Integer.parseInt(timer);
        int seconds = minutes*60;
        countDownTimer = new CountDownTimer( seconds* 1000+1000, 1000) {

            @Override
            public void onTick(long l) {
                int seconds=(int) (l/1000);
                int minutes= seconds/60;
                seconds = seconds % 60;
                time1.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));

            }

            public void onFinish() {

                time1.setText("Done");
            }

        };

        countDownTimer.start();

    }//End of Start


    private void cancel(){
        if(countDownTimer!=null){
            countDownTimer.cancel();
            countDownTimer = null;
        }


    }
*/

      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor=sharedPreferences.edit();


        prefList1 = sharedPreferences.getString("PREF_FOCUS", "no selection");
        focus_time=prefList1.toString()+" mins";

        prefList2 = sharedPreferences.getString("PREF_SBREAK", "no selection");
        sbreak_time=prefList2.toString()+" mins";

        prefList3 = sharedPreferences.getString("PREF_LBREAK", "no selection");
        lbreak_time=prefList3.toString()+" mins";

        focustv.setText(focus_time);
        if (work_flag == true)
        {
            time1.setText(prefList1.toString() + ":00");
        }
        else if (sbreak_flag == true)
        {
            time1.setText(prefList2.toString() + ":00");

        }
        else if (lbreak_flag == true)
        {
              time1.setText(prefList3.toString() + ":00");
        }

        sbreaktv.setText(sbreak_time);
        lbreaktv.setText(lbreak_time);
        //time1.setText(prefList1.toString()+":00");

          if (requestCode == 1) {
              if(resultCode == Activity.RESULT_OK && work_flag){
                  msg.setText("Task has been done. Take a break");
                  success_block += 1;
                   worktime=prefList1.toString();
                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder.setTitle("Task status");
                  //status= new EditText(MainActivity.this);
                  builder.setMessage("Is the task completed succesfully");
                  builder.setView(status);
                  builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {

                          taskstatus = "yes";
                          insertData();
                          Toast.makeText(MainActivity.this,"Task status is "+taskstatus,Toast.LENGTH_LONG).show();
                      }
                  });

                  builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          taskstatus = "no";
                          insertData();
                          dialog.dismiss();
                          //Toast.makeText(MainActivity.this,"Task status is "+taskstatus,Toast.LENGTH_LONG).show();
                          AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                          builder1.setTitle("Restart Task");
                          builder1.setMessage("Do you want to restart the task?");
                          builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                  finish();
                                  dialog.cancel();
                              }
                          });
                          builder1.setNegativeButton("No",new DialogInterface.OnClickListener() {
                              public void onClick(DialogInterface dialog, int which)
                              {
                                  MainActivity.this.finish();
                              }
                          });
                           AlertDialog ad1 = builder1.create();
                           ad1.show();
                      }
                  });

                  AlertDialog ad=builder.create();
                  ad.show();

                  if(txt == null)
                  {
                      txt="Work";
                  }
                                                     //Toast.makeText(getApplicationContext(),"Completed Task "+ success_block+ " succesfully",Toast.LENGTH_LONG).show();
                  editor.putInt("block_count", success_block);
                  editor.commit();

                  //Toast.makeText(getApplicationContext(),"Shared Preference Saved",Toast.LENGTH_LONG).show();

              }


              if(resultCode == Activity.RESULT_OK && sbreak_flag){
                  msg.setText("Short Break has been done, Get back to work");
                  worktime=prefList2.toString();
                  if(txt == null)
                  {
                      txt="Short Break";
                  }
                  taskstatus="Short Break";
                  insertData();
                  editor.putInt(getString(R.string.pref_sbreak_count), sbreak_block);
                  editor.commit();


              }
              if(resultCode == Activity.RESULT_OK && lbreak_flag){
                  msg.setText("Long Break has been done, Get back to work");
                  worktime=prefList3.toString();
                  if(txt == null)
                  {
                      txt="Long Break";
                  }
                  taskstatus="Long Break";
                  insertData();
                  editor.putInt(getString(R.string.pref_lbreak_count), lbreak_block);
                  editor.commit();



              }

              Log.i("111",""+work_flag);
              Log.i("222",""+sbreak_flag);
              Log.i("333",""+lbreak_flag);
              if (resultCode == Activity.RESULT_CANCELED && work_flag) {

                 msg.setText("No Problem, Continue the task after some time");
             }

              if (resultCode == Activity.RESULT_CANCELED && sbreak_flag ) {
                  //Write your code if there's no result
                  msg.setText("No Problem, Take a break after some time");
              }
              if (resultCode == Activity.RESULT_CANCELED && lbreak_flag ) {
                  //Write your code if there's no result
                  msg.setText("No Problem, Take a break after some time");
              }
              /*if (resultCode == Activity.RESULT_CANCELED && lbreak_flag) {
                  //Write your code if there's no result
                  msg.setText("No Problem, Take a break after some time");
              }*/
          }// End of Result code

    }

    public void insertData() {

        final MyDataBase mdb=new MyDataBase(getApplicationContext(), DATABASENAME, null, DATABASEVERSION);
        Toast.makeText(getApplicationContext()," Value of today:" +today,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext()," Value of label:" +txt,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext()," Value of focus_time:" +worktime,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext()," Value of task status:" +taskstatus,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext()," Value of work hours:" + block_hours,Toast.LENGTH_LONG).show();

        //today refers to DATE on which the focus session is used
        //txt is used to refer label for the session. for ex: work, gym etc
        //worktime refers if it a focus session, short break time or long break time
        //block_hours refers to the max number of hours working per day

        if ( today !=null && txt != null && focus_time != null && (taskstatus == "yes" || taskstatus == "no" || taskstatus=="Short Break" || taskstatus=="Long Break" )) {
            Toast.makeText(getApplicationContext(), "Task values are:" + today + " "+txt + " "+ worktime+" "+ taskstatus +" "+ block_hours, Toast.LENGTH_LONG).show();
            boolean isInserted = mdb.insertData(today,txt,worktime,taskstatus,block_hours);
            if (isInserted == true)
            {
                Toast.makeText(MainActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Data is not inserted",Toast.LENGTH_LONG).show();
            }
        }

    }

}