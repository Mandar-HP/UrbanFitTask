package com.example.urbanfit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TrackerPage extends Fragment {

    Button sleepTrack, ccalorieTrack, waterTrack;

    public TrackerPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewWaterFrag = inflater.inflate(R.layout.fragment_tracker_page, container, false);

        sleepTrack = viewWaterFrag.findViewById(R.id.sleepTrackXml);
        waterTrack = viewWaterFrag.findViewById(R.id.waterTrackXml);
        ccalorieTrack = viewWaterFrag.findViewById(R.id.calorieTrackXml);

        ccalorieTrack.setOnClickListener(new MyClickListenerTrackers());
        waterTrack.setOnClickListener(new MyClickListenerTrackers());
        sleepTrack.setOnClickListener(new MyClickListenerTrackers());

        return  viewWaterFrag;
    }

    public class MyClickListenerTrackers implements View.OnClickListener{

        @Override
        public void onClick(View v) {


            if (v == waterTrack){
                WaterTracker waterFragObj = new WaterTracker();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,waterFragObj).commit();
                //layoutObj.setVisibility(View.VISIBLE);
            }
            else if (v == ccalorieTrack){
                CalorieTracker calorieFrag = new CalorieTracker();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,calorieFrag).commit();
                //layoutObj.setVisibility(View.VISIBLE);
            }
            else if (v == sleepTrack){
                SleepTracker sleepFrag = new SleepTracker();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainScren,sleepFrag).commit();
                //layoutObj.setVisibility(View.VISIBLE);
            }

        }

    }

}