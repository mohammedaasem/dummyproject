package com.aasem.inspire_info_soft.myschool.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.UserStudentTop;
import com.aasem.inspire_info_soft.myschool.R;
import com.aasem.inspire_info_soft.myschool.SharedPrefManager;
import com.aasem.inspire_info_soft.myschool.Utill.URL;
import com.bumptech.glide.Glide;
import com.lovejjfg.shadowcircle.CircleImageView;

public class Profile extends Fragment {

   TextView tvUserName,tvClass,tvDivision,tvRollNumber,tvAttendance,tvPerformance,tvFatherName,tvMotherName,tvGender,tvDOB,tvAdhaarNumber,tvContactNumber,tvBloodGroup,tvAddress,tvAdmissionDate,tvStudentID,tvRegistrationNumber;
   CircleImageView ivProfile;
   Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View view= inflater.inflate(R.layout.fragment_profile, container, false);
     init(view);
     setdata();
     return view;
    }

    private void setdata() {
        UserStudentTop userStudent = SharedPrefManager.getInstance(getActivity()).getUserStudent();
        tvRollNumber.setText(""+userStudent.getRollNo());
        tvUserName.setText(""+userStudent.getName());
        tvGender.setText(""+userStudent.getGender());
        tvClass.setText(""+userStudent.getClass_());
        tvDivision.setText(""+userStudent.getClass_());
        tvFatherName.setText(""+userStudent.getFatherName());
        tvMotherName.setText(""+userStudent.getMotherName());
        tvDOB.setText(""+userStudent.getDob());
        tvAdhaarNumber.setText(""+userStudent.getAdhaarNo());
        tvContactNumber.setText(""+userStudent.getContactNo());
        tvAddress.setText(""+userStudent.getAddress());
        tvBloodGroup.setText(""+userStudent.getBloodGroup());
        tvRegistrationNumber.setText(""+userStudent.getRollNo());
        tvAdmissionDate.setText(""+userStudent.getAdmissionDate());
        tvAttendance.setText("-");
        tvPerformance.setText("-");
        Glide.with(getActivity())
                .load(URL.dp_folder+userStudent.getProfile())
                .dontAnimate()
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into(ivProfile);
    }

    private void init(View view) {
        tvUserName=(TextView)view.findViewById(R.id.tv_user_name);
        tvFatherName=(TextView)view.findViewById(R.id.tv_father_name);
        tvMotherName=(TextView)view.findViewById(R.id.tv_mother_name);
        tvGender=(TextView)view.findViewById(R.id.tv_gender);
        tvBloodGroup=(TextView)view.findViewById(R.id.tv_blood_group);
        tvDOB=(TextView)view.findViewById(R.id.tv_dob);
        tvAdhaarNumber=(TextView)view.findViewById(R.id.tv_adhaar_number);
        tvContactNumber=(TextView)view.findViewById(R.id.tv_contact_number);
        tvAddress=(TextView)view.findViewById(R.id.tv_address);
        tvClass=(TextView)view.findViewById(R.id.tv_class);
        tvDivision=(TextView)view.findViewById(R.id.tv_division);
        tvRollNumber=(TextView)view.findViewById(R.id.tv_roll_number);
        tvAttendance=(TextView)view.findViewById(R.id.tv_attendence);
        tvPerformance=(TextView)view.findViewById(R.id.tv_performance);
        tvRegistrationNumber=(TextView)view.findViewById(R.id.tv_registration_number);
        tvAdmissionDate=(TextView)view.findViewById(R.id.tv_admission_date);
        ivProfile=(CircleImageView) view.findViewById(R.id.iv_profile);
    }
}
