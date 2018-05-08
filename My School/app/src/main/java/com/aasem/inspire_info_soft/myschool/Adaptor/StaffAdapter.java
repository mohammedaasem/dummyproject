package com.aasem.inspire_info_soft.myschool.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.StaffData;
import com.aasem.inspire_info_soft.myschool.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inspire_info_soft on 2/12/2018.
 */

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<StaffData> staffList;

    public StaffAdapter(Context mContext, ArrayList<StaffData> staffList) {
        this.mContext = mContext;
        this.staffList = staffList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvFacName,tvFacExperience,tvFacQualification,tvFacSubject;
        public ImageView ivProfile;

        public MyViewHolder(View view) {
            super(view);
            tvFacName = (TextView) view.findViewById(R.id.tv_faculty_name);
            tvFacExperience = (TextView) view.findViewById(R.id.tv_experience);
            tvFacQualification = (TextView) view.findViewById(R.id.tv_qualification);
            tvFacSubject = (TextView) view.findViewById(R.id.tv_subject);
            ivProfile = (ImageView) view.findViewById(R.id.iv_profile);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_design_staff, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        StaffData  staffData = staffList.get(position);
        holder.tvFacName.setText(staffData.getFacultyName());
        holder.tvFacQualification.setText(staffData.getFacultyQualification());
        holder.tvFacExperience.setText(staffData.getFacultyExperience());
        holder.tvFacSubject.setText(staffData.getFacultySubject());
        // loading album cover using Glide library
        Glide.with(mContext).load(staffData.getProfileImage()).into(holder.ivProfile);
    }


    @Override
    public int getItemCount() {
        return staffList.size();
    }
}