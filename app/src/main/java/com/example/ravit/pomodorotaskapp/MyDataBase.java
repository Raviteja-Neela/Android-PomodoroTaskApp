package com.example.ravit.pomodorotaskapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ravit on 4/24/2018.
 */

public class MyDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "timer.db";
    private static final int DATABASEVERSION = 1;
    public static final String TABLE_NAME = "wokrtimer_table";
    public static final String COL1 = "SNO";
    public static final String COL2 = "DATE";
    public static final String COL3 = "WORKTAG";
    public static final String COL4 = "WORKTIME";
    public static final String COL5 = "TASKSTATUS";
    public static final String COL6 = "TOTALTIME";
    public String today;

    public MyDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS "+ TABLE_NAME + " " + "(SNO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, DATE TEXT,WORKTAG TEXT,WORKTIME TEXT, TASKSTATUS TEXT, TOTALTIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String date, String worktag, String worktime, String taskstatus, String totaltime) {
        //db.execSQL("insert into TABLE_NAME values('"+s1+"',"+"'"+s2+"',"+"'"+s3+"',"+"'"+s4+"')");
        SQLiteDatabase db = this.getWritableDatabase();
        Log.i("555","Opended db");
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,date);
        contentValues.put(COL3,worktag);
        contentValues.put(COL4,worktime);
        contentValues.put(COL5,taskstatus);
        contentValues.put(COL6,totaltime);

        long result= db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public ArrayList<TaskInfo> retrieveData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<TaskInfo> alist=new ArrayList<TaskInfo>();
        TaskInfo ts=new TaskInfo();
        //String currentDate = DateFormat.getDateInstance( ).format(Calendar.getInstance().getTime());
        //String currentDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(Calendar.getInstance().getTime());
        Date date1 = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date1);
        Log.i("Today:",today);

        Cursor c = db.rawQuery("select * from wokrtimer_table", null);
        Log.i("dbstore", "here");
        while (c.moveToNext())
        {
            if(c.getString(1).equals(today)) {
            String date=c.getString(1);
            Log.i("Date:",date);
            String worktag=c.getString(2);
            String worktime=c.getString(3);
            String taskstatus=c.getString(4);
            String totaltime=c.getString(5);

            Log.i("dbstore cur", date);
            //Log.i("dbstore cur", worktag);
            ts=new TaskInfo();

                ts.setDate(date);
                ts.setWorkTag(worktag);
                ts.setWorkTime(worktime);
                ts.setTaskStatus(taskstatus);
                ts.setTotalTime(totaltime);
                alist.add(ts);
            }
        }
        return alist;
    }




}
