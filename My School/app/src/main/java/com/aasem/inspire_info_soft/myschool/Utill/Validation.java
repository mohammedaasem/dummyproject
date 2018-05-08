package com.aasem.inspire_info_soft.myschool.Utill;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by inspire_info_soft on 1/26/2018.
 */

public class Validation {
    public static boolean isEmptyorNull(String data)
    {
        if(data==null || data.equals(""))
        {
            return true;
        }
        return false;
    }

}
