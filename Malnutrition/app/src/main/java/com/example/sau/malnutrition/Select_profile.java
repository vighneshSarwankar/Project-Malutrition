package com.example.sau.malnutrition;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Select_profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profile);
    }
    public void callProfile(View view)
    {
        Intent intent = new Intent(Select_profile.this, Profile.class);
        startActivity(intent);
    }

    public void callExisting(View view)
    {
        Intent intent = new Intent(Select_profile.this, Existing.class);
        startActivity(intent);
    }
}

