package com.example.sau.malnutrition;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Capture_image extends Fragment implements View.OnClickListener {

    Button front,side;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_capture_image, container, false);
        front = (Button) view.findViewById(R.id.btn_front_view);
        front.setOnClickListener(this);
        side = (Button) view.findViewById(R.id.btn_side_view);
        side.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        Intent myIntent;
        switch(v.getId()) {
            case R.id.btn_front_view:
                myIntent = new Intent(getActivity(),Camera.class);
                startActivity(myIntent);
                break;
            case R.id.btn_side_view:
                myIntent = new Intent(getActivity(),Camera.class);
                startActivity(myIntent);
                break;


        }
    }
}
