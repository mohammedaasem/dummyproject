package com.aasem.inspire_info_soft.myschool.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aasem.inspire_info_soft.myschool.Adaptor.StaffAdapter;
import com.aasem.inspire_info_soft.myschool.DataClasses.StaffData;
import com.aasem.inspire_info_soft.myschool.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HomeStaff extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<StaffData> staffData;
    StaffAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home_staff, container, false);
        getActivity().setTitle("Staff Members");
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        staffData = new ArrayList<>();
        adapter = new StaffAdapter(getActivity(), staffData);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        setData();
        return view;
    }

    private void setData(){
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));
        staffData.add(new StaffData("Mohammed Aasem","BE in Computer Engg.","2+ Experience","Android / PHP",R.drawable.user));

    }


}
