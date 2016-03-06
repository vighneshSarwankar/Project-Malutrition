package com.example.sau.malnutrition;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;


public class Profile extends FragmentActivity {

    ViewPager viewpage=null;
    Button front,side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        viewpage= (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewpage.setAdapter(new MyAdapter(fragmentManager));
    }

}


class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {

        Fragment fragment=null;
        if(i==0)
            fragment=new Child_profile();
        else if(i==1)
            fragment=new Profile_physical();
        else if(i==2)
            fragment=new Capture_image();
        else if(i==3)
            fragment=new User_action();

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        if(i==0)
            return "Profile";
        else if(i==1)
            return "Physical";
        else if(i==2)
            return "Images";
        else if(i==3)
            return "User_action";
        return null;
    }
}