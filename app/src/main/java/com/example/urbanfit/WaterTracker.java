package com.example.urbanfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class WaterTracker extends Fragment {


    Spinner waterGlassSpinn;
    ArrayAdapter<String> adapterObj;
    Button submitBtn;

    String selection;

    public WaterTracker() {
        // Required empty public constructor
    }



    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View viewWaterFrag = inflater.inflate(R.layout.fragment_water_tracker, container, false);

        submitBtn = viewWaterFrag.findViewById(R.id.submitBtnXml);
        submitBtn.setOnClickListener(new MyClickListener());

        waterGlassSpinn = viewWaterFrag.findViewById(R.id.waterGlassSpinner);

        String [] waterGlassArr = {"0","1","2","3","4","5","6","7","8","9"};

        adapterObj = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,waterGlassArr);

        adapterObj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        waterGlassSpinn.setOnItemSelectedListener(new ItemSelectListener());

        waterGlassSpinn.setAdapter(adapterObj);

        return viewWaterFrag;

    }




    // FOR SPINNER ITEMS SELECTION OPERATIONS :

    public class ItemSelectListener implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selection = parent.getItemAtPosition(position).toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    public class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v == submitBtn){

                Intent intntForMainAct = new Intent(getActivity(),MainScreenActivity. class);
                intntForMainAct.putExtra("waterglass",selection);
                startActivity(intntForMainAct);
            }

        }
    }



}