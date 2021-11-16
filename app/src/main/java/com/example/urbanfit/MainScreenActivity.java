package com.example.urbanfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreenActivity extends AppCompatActivity {

    Button calorieBtn,waterBtn,sleepBtn,workoutBtn,trackerPgBtn;

    String waterFragStrngData,sleepHrsDataStrng,calorieDataStrng;

    TextView waterDataTxt,sleepHrsTxt,calorieTxt;

    LinearLayout layoutObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initialize();

        Intent waterFrag = getIntent();

        databaseProcessing(waterFrag);

    }

    public void initialize(){
        calorieBtn = findViewById(R.id.calorieBtnXml);
        sleepBtn = findViewById(R.id.sleepBtnXml);
        waterBtn = findViewById(R.id.waterBtnXml);
        workoutBtn = findViewById(R.id.workoutBtnXml);
        trackerPgBtn = findViewById(R.id.trackBttnXml);

        calorieBtn.setOnClickListener(new trackerPageNavigate());
        sleepBtn.setOnClickListener(new trackerPageNavigate());
        waterBtn.setOnClickListener(new trackerPageNavigate());
        workoutBtn.setOnClickListener(new trackerPageNavigate());
        trackerPgBtn.setOnClickListener(new trackerPageNavigate());

        waterDataTxt = findViewById(R.id.waterDataTxtBoxXml);
        sleepHrsTxt = findViewById(R.id.sleepHrsTxtBoxXml);
        calorieTxt = findViewById(R.id.calorieIntakeTxtBoxXml);

        layoutObj = findViewById(R.id.frameLayoutMainScren);

    }




    public void databaseProcessing(Intent intentObj){

        waterFragStrngData = intentObj.getStringExtra("waterglass");
        sleepHrsDataStrng = intentObj.getStringExtra("sleepHrs");
        calorieDataStrng = intentObj.getStringExtra("calorieIntake");

        waterDataTxt.setText(waterFragStrngData);
        sleepHrsTxt.setText(sleepHrsDataStrng);
        calorieTxt.setText(calorieDataStrng);

        SQLiteDatabase databaseObj;
        databaseObj = openOrCreateDatabase("urbanfitDB",MODE_PRIVATE,null);

       /* Cursor cursorObj = databaseObj.rawQuery("select * from trackerTable", null, null);

        if (cursorObj.moveToNext()){

            while (cursorObj.moveToNext()){
                String cursorResponseStrng = cursorObj.getString(1);
                waterDataTxt.setText(cursorResponseStrng);
                cursorObj.close();
            }

        }
        else {}*/

            try {
                databaseObj.execSQL("create table trackerTable (waterConsmption text,sleepHrs text,calories text)");
            }
            catch (Exception e){

            }

            ContentValues contentValuesObj = new ContentValues();
            contentValuesObj.put("waterConsmption",waterFragStrngData);
            contentValuesObj.put("sleepHrs",sleepHrsDataStrng);
            contentValuesObj.put("calories",calorieDataStrng);

            Cursor cursorObj = databaseObj.rawQuery("select * from trackerTable", null, null);

           /* if (cursorObj.moveToNext()){
                databaseObj.update("trackerTable",contentValuesObj,null,null);
            }

            else {*/

                long trackerTable = databaseObj.insert("trackerTable",null ,contentValuesObj);

                if (trackerTable > -1){
                    Toast.makeText(this, "Database insertion Successful !", Toast.LENGTH_SHORT).show();
                }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflatrObj = getMenuInflater();
        menuInflatrObj.inflate(R.menu.menu_items,menu);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.userProfileMenu){

            UserProfileFragment userprofFrag = new UserProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,userprofFrag).commit();

        }
        return super.onOptionsItemSelected(item);
    }



    public class trackerPageNavigate implements View.OnClickListener {

        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {

            if (v == trackerPgBtn){
                TrackerPage trakerPgFragObj = new TrackerPage();
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,trakerPgFragObj).commit();
            }
            else if (v == waterBtn){
                WaterTracker waterFragObj = new WaterTracker();
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,waterFragObj).commit();
                //layoutObj.setVisibility(View.VISIBLE);
            }
            else if (v == calorieBtn){
                CalorieTracker calorieFrag = new CalorieTracker();
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,calorieFrag).commit();
                //layoutObj.setVisibility(View.VISIBLE);
            }
            else if (v == sleepBtn){
                SleepTracker sleepFrag = new SleepTracker();
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,sleepFrag).commit();
                //layoutObj.setVisibility(View.VISIBLE);
            }

        }
    }







}