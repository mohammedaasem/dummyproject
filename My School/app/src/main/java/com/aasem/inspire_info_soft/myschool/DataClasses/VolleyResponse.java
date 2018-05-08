package com.aasem.inspire_info_soft.myschool.DataClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by inspire_info_soft on 2/19/2018.
 */

public class VolleyResponse {
    int status;
    String msg;

    @SerializedName("info")
    @Expose
    UserStudentTop info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserStudentTop getUserStudentTop() {
        return info;
    }

    public void setUserStudentTop(UserStudentTop userStudentTop) {
        this.info = userStudentTop;
    }
}
