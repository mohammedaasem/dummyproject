package com.aasem.inspire_info_soft.myschool.Utill;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
   public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
   public static boolean checkPermission(final Context context)
   {
       int currentAPIVersion = Build.VERSION.SDK_INT;
       if(currentAPIVersion>= Build.VERSION_CODES.M)
       {
           if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
               if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                   AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                   alertBuilder.setCancelable(true);
                   alertBuilder.setTitle("Permission necessary");
                   alertBuilder.setMessage("External storage permission is necessary");
                   alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                       @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                       public void onClick(DialogInterface dialog, int which) {
                           ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                       }
                   });
                   AlertDialog alert = alertBuilder.create();
                   alert.show();
               } else {
                   ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
               }
               return false;
           } else {
               return true;
           }
       } else {
           return true;
       }
   }

    public static Date getDateFromStringyyyy_mm_dd(String stringdate)
    {
        String dateString = stringdate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDisplayableTime(Date date)
    {
        long delta=date.getTime();
        long difference=0;
        Long mDate = System.currentTimeMillis();

        if(mDate > delta)
        {
            difference= mDate - delta;
            final long seconds = difference/1000;
            final long minutes = seconds/60;
            final long hours = minutes/60;
            final long days = hours/24;
            final long months = days/31;
            final long years = days/365;

            if (seconds < 0)
            {
                return "not yet";
            }
            else if (seconds < 60)
            {
                return seconds == 1 ? "one second ago" : seconds + " seconds ago";
            }
            else if (seconds < 120)
            {
                return "a minute ago";
            }
            else if (seconds < 2700) // 45 * 60
            {
                return minutes + " minutes ago";
            }
            else if (seconds < 5400) // 90 * 60
            {
                return "an hour ago";
            }
            else if (seconds < 86400) // 24 * 60 * 60
            {
                return hours + " hours ago";
            }
            else if (seconds < 172800) // 48 * 60 * 60
            {
                return "yesterday";
            }
            else if (seconds < 2592000) // 30 * 24 * 60 * 60
            {
                return days + " days ago";
            }
            else if (seconds < 31104000) // 12 * 30 * 24 * 60 * 60
            {

                return months <= 1 ? "one month ago" : days + " months ago";
            }
            else
            {

                return years <= 1 ? "one year ago" : years + " years ago";
            }
        }
        return "";
    }

}