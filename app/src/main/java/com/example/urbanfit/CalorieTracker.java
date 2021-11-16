package com.example.urbanfit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CalorieTracker extends Fragment {

    Spinner waterGlassSpinn;
    ArrayAdapter<String> adapterObj;
    Button submitBtn;

    String selection;


    public CalorieTracker() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewWaterFrag = inflater.inflate(R.layout.fragment_calorie_tracker, container, false);

        submitBtn = viewWaterFrag.findViewById(R.id.submitBtncalorieXml);
        submitBtn.setOnClickListener(new MyClickListenerCalorie());

        waterGlassSpinn = viewWaterFrag.findViewById(R.id.calorieSpinner);

        String [] waterGlassArr = {"100","150","200","250","300","350","400","450","500"};

        adapterObj = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,waterGlassArr);

        adapterObj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        waterGlassSpinn.setOnItemSelectedListener(new ItemSelectListenerCalorie());

        waterGlassSpinn.setAdapter(adapterObj);

        return viewWaterFrag;
    }

    public class ItemSelectListenerCalorie implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selection = parent.getItemAtPosition(position).toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public class MyClickListenerCalorie implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v == submitBtn){

                Intent intntForMainAct = new Intent(getActivity(),MainScreenActivity. class);
                intntForMainAct.putExtra("calorieIntake",selection);
                startActivity(intntForMainAct);
            }

        }
    }
}