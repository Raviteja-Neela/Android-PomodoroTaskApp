package com.example.ravit.pomodorotaskapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ravit on 3/26/2018.
 */

public class GoalActivity extends AppCompatActivity {

    private ListView list;
    public static final String DATABASE_NAME = "timer.db";
    private static final int DATABASEVERSION = 1;
    ArrayList<TaskInfo> alist;
    TaskInfo ts;
    MyArrayAdapter mad;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        list = (ListView) findViewById(R.id.list);
        alist = new ArrayList<TaskInfo>();
        ts = new TaskInfo();

        final MyDataBase mdb = new MyDataBase(getApplicationContext(), DATABASE_NAME, null, DATABASEVERSION);

        alist = mdb.retrieveData();
        mad = new MyArrayAdapter();

        if (alist.size()!=0)
        {

            list.setAdapter(mad);

        }
        else
        {

            Toast.makeText(getApplicationContext(),"No work has been done for today" ,Toast.LENGTH_LONG).show();
        }



    }
    /*private TextView goal,stats;
    private SharedPreferences sharedPref;
    private int blockValue;
    private String defaultBlockVal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        //goal=(TextView)findViewById(R.id.goaltv);
        //stats=(TextView)findViewById(R.id.statstv);
        //sharedPref = PreferenceManager.getDefaultSharedPreferences(GoalActivity.this);
        // sharedPref=getSharedPreferences("pref_block_count",0);
        //    defaultBlockVal = getResources().getInteger(R.integer.pref_block_count);
        // blockValue=sharedPref.getInt("block_count",0);
        //goal.setText("No. of blocks completed"+blockValue);

    }*/


    class MyArrayAdapter extends BaseAdapter {
        TextView worktag, worktime, taskstatus;

        public int getCount() {

            return alist.size();
        }

        public void updateData() {

            notifyDataSetChanged();

        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View v, ViewGroup arg2) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View v1 = inflater.inflate(R.layout.custom, null);
            worktag = (TextView) v1.findViewById(R.id.worktag);
            worktime = (TextView) v1.findViewById(R.id.worktime);
            taskstatus = (TextView) v1.findViewById(R.id.taskstatus);

            String s11 = alist.get(position).getWorkTag();
            String s12 = alist.get(position).getWorkTime();
            String s13 = alist.get(position).getTaskStatus();

            worktag.setText("Work Performed: " + s11);
            worktime.setText("Time focused:" + s12 + "mins");
            if (s13.equals("yes"))
            {
                taskstatus.setText("Status of the task: Succesful" );
            }
            else if (s13.equals("no"))
            {
                taskstatus.setText("Status of the task: Unsuccesful" );
            }
            else
            {
                taskstatus.setText("Status of the task: " + s13 );
            }

            return v1;
        }
    }

}
