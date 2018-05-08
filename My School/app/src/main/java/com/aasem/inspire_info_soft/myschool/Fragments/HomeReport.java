package com.aasem.inspire_info_soft.myschool.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aasem.inspire_info_soft.myschool.R;

import java.util.ArrayList;
import java.util.List;

import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;


public class HomeReport extends Fragment {

    BarChart barChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.home_report, container, false);
        barChart = (BarChart) view.findViewById(R.id.bar_chart_vertical);
        barChart.setBarMaxValue(100);

        BarChartModel englishBar = new BarChartModel();
        englishBar.setBarValue(50);
        englishBar.setBarColor(Color.parseColor("#9C27B0"));
        englishBar.setBarTag(null); //You can set your own tag to bar model
        englishBar.setBarText("50");
        barChart.addBar(englishBar);




        return view;
    }

}