package com.aasem.inspire_info_soft.myschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UserType extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioGroup;
    RadioButton rbStaff,rbStudent;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        init();
        btnNext.setOnClickListener(this);
    }

    private void init() {
        radioGroup=(RadioGroup)findViewById(R.id.rb_user_type);
        rbStaff=(RadioButton)findViewById(R.id.rb_staff);
        rbStudent=(RadioButton)findViewById(R.id.rb_student);
        btnNext=(Button)findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View view) {
        int selectedID=radioGroup.getCheckedRadioButtonId();
        if(selectedID==R.id.rb_student){
            startActivity(new Intent(this,RegistrationStudent.class));
            finish();
        }
        if(selectedID==R.id.rb_staff){
            startActivity(new Intent(this,RegistrationStaff.class));
            finish();
        }
    }
}
