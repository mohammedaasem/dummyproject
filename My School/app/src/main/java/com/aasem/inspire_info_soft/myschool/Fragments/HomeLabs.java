package com.aasem.inspire_info_soft.myschool.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aasem.inspire_info_soft.myschool.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class HomeLabs extends Fragment {

    /*CarouselView carouselView;
    int[] labImages = {R.drawable.ic_user, R.drawable.ic_aadhaar_logo};*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home_labs, container, false);
       /* carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setPageCount(labImages.length);
        carouselView.setImageListener(imageListener);*/
        return view;
    }

   /* ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(labImages[position]);
        }
    };*/

}