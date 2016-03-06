package com.example.sau.malnutrition;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sau.malnutrition.TableData.*;

public class Child_profile extends Fragment {
    EditText id,name,age,mothername,village,district,contactno;
    RadioGroup rgGender;
    String id_s,gender_s,name_s,age_s,mothername_s,village_s,district_s,contactno_s;
    Context ctx;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.child_profile,container,false);
        Button reset=(Button)view.findViewById(R.id.btn_child_reset);
        Button save=(Button)view.findViewById(R.id.btn_child_save);
        id= (EditText)view.findViewById(R.id.edit_id);
        name= (EditText)view.findViewById(R.id.edit_name);
        age= (EditText)view.findViewById(R.id.edit_age);
        rgGender= (RadioGroup)view.findViewById(R.id.radioGroup);
        mothername= (EditText)view.findViewById(R.id.edit_mother);
        village= (EditText)view.findViewById(R.id.edit_village);
        district= (EditText)view.findViewById(R.id.edit_district);
        contactno= (EditText)view.findViewById(R.id.edit_contact);
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                id.setText("");
                name.setText("");
                age.setText("");
                name.setText("");
                village.setText("");
                district.setText("");
                contactno.setText("");
            }
        });

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                id_s=id.getText().toString();
                name_s=name.getText().toString();
                age_s=age.getText().toString();
                gender_s = name.getText().toString();
                mothername_s=mothername.getText().toString();
                village_s=village.getText().toString();
                district_s=district.getText().toString();
                contactno_s=contactno.getText().toString();
                DatabaseOperations dbo = new DatabaseOperations(ctx);
                Child_Profile.putInformation(dbo,name_s,age_s,gender_s,mothername_s,village_s,district_s,contactno_s);
                Toast.makeText(ctx, "Record Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }
}
