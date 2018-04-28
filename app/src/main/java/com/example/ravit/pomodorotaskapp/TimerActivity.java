package com.example.ravit.pomodorotaskapp;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by ravit on 4/2/2018.
 */

public class TimerActivity extends AppCompatActivity {

    public TextView timertv,msgtv1;
    private ImageButton stop1;
    private CountDownTimer countDownTimer;
    private String timer,intent_msg1;
    private boolean flag;
    private int complete_block;
    private Intent i1;
    private SoundPool soundPool;
    private SparseIntArray soundMap;
    private int soundId;


    //private Intent timerActivity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        timertv=(TextView)findViewById(R.id.timertv);
        msgtv1=(TextView)findViewById(R.id.msgtv);
        stop1=(ImageButton)findViewById(R.id.stop1);
        flag=true;

        configureSounds();



        timer = getIntent().getExtras().getString("ClockVal");
        intent_msg1 = getIntent().getExtras().getString("IntentMsg");
        Log.i("555",intent_msg1);
        i1=new Intent();

        Log.i("666",""+complete_block);
        start();
        Log.i("timer value",timer);
        stop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cancel();
                //Intent i1= new Intent(TimerActivity.this,MainActivity.class);
                //i1.putExtra("timerDone",int);

                setResult(Activity.RESULT_CANCELED,i1);
                finish();
                //startActivity(i1);
            }
        });




    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
            /*if ((keyCode == KeyEvent.KEYCODE_HOME)) {
                System.out.println("KEYCODE_HOME");
//showDialog("'HOME'");
                return false;
            }*/
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            System.out.println("KEYCODE_BACK");
//showDialog("'BACK'");
            return false;
        }

        return false;
    }


    private void configureSounds() {

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundMap = new SparseIntArray(4);
        soundMap.put(1, soundPool.load(this, R.raw.alarm, 1));
    }

    private void start() {
        int minutes = Integer.parseInt(timer);
        int seconds = minutes*60;
        countDownTimer = new CountDownTimer( seconds* 1000+1000, 1000) {


            @Override
            public void onTick(long l) {
                int seconds=(int) (l/1000);
                int minutes= seconds/60;
                seconds = seconds % 60;
                if(intent_msg1.equals("work")) {
                    msgtv1.setText("Work as much as you can");
                }
                else if(intent_msg1.equals("sbreak")) {
                    msgtv1.setText("Take a short break");
                }
                else if(intent_msg1.equals("lbreak")) {
                    msgtv1.setText("Take a long break");
                }
                timertv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));

            }

            public void onFinish() {

                timertv.setText("00:00");

                soundPool.play(1, 1, 1, 1, 0, 1.0f);

                // complete_block = complete_block + 1;
                Log.i("777",""+complete_block);
                //i1.putExtra("block",complete_block);
                setResult(Activity.RESULT_OK,i1);

                Log.i("200",""+flag);

                finish();
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

    @Override
    protected void onResume() {
        super.onResume();

    }
}
