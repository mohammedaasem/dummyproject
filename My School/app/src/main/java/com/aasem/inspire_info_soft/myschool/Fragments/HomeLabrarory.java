package com.aasem.inspire_info_soft.myschool.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aasem.inspire_info_soft.myschool.Adaptor.LabraryAdapter;
import com.aasem.inspire_info_soft.myschool.Adaptor.StaffAdapter;
import com.aasem.inspire_info_soft.myschool.DataClasses.HomeLabrory;
import com.aasem.inspire_info_soft.myschool.R;

import java.util.ArrayList;

public class HomeLabrarory extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<HomeLabrory> labrarories;
    LabraryAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_labrarory, container, false);
        getActivity().setTitle("Library");
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        labrarories = new ArrayList<>();
        adapter = new LabraryAdapter(getActivity(), labrarories);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        setData();
        return view;
    }

    private void setData() {
        labrarories.add(new HomeLabrory("Java Programming","S Gaikwad","Tech-Maxx","2013","20"));
        labrarories.add(new HomeLabrory("Java Programming","S Gaikwad","Tech-Maxx","2013","20"));
        labrarories.add(new HomeLabrory("Java Programming","S Gaikwad","Tech-Maxx","2013","20"));
        labrarories.add(new HomeLabrory("Java Programming","S Gaikwad","Tech-Maxx","2013","20"));
        labrarories.add(new HomeLabrory("Java Programming","S Gaikwad","Tech-Maxx","2013","20"));
        labrarories.add(new HomeLabrory("Java Programming","S Gaikwad","Tech-Maxx","2013","20"));

    }


}
