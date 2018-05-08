package com.aasem.inspire_info_soft.myschool;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.aasem.inspire_info_soft.myschool.DataClasses.UserStudentTop;

/**
 * Created by inspire_info_soft on 2/4/2018.
 */

public class SharedPrefManager {
    //the constants
    private static final String SHARED_PREF_NAME = "studentsharedpref";
    private static final String KEY_ID_NO = "id_no";
    private static final String KEY_ACADEMIC_YEAR = "academicYear";
    private static final String KEY_LOGIN_USER_TYPE = "login_user_type";
    private static final String KEY_NAME = "name";
    private static final String KEY_CAST = "case";
    private static final String KEY_RELIGION = "religion";
    private static final String KEY_FATHER_NAME = "father_name";
    private static final String KEY_MOTHER_NAME = "mother_name";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_BLOOD_GROUP = "blood_group";
    private static final String KEY_STATE = "state";
    private static final String KEY_NATIONALITY = "nationality";
    private static final String KEY_ADHAAR_NO = "adhaar_number";
    private static final String KEY_CONTACT_NO = "contact_number";
    private static final String KEY_FATHER_CONTACT_NO = "father_contact_number";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CLASS = "class";
    private static final String KEY_DIVISION = "division";
    private static final String KEY_ROLL_NO = "roll_no";
    private static final String KEY_DOB = "date_of_birth";
    private static final String KEY_REGISTRATION_NUMBER= "registration_number";
    private static final String KEY_ADMISSION_DATE= "admission_date";
    private static final String KEY_DP= "dp";
    private static final String KEY_SPECIAL_SUBJECT= "specialSubject";
    private static final String KEY_EXPERIANCE= "experience";
    private static final String KEY_QUALIFICATION= "qualification";
    private static final String KEY_REG_DATE= "regDate";
    private static SharedPrefManager mInstance;
    private static SharedPreferences mPreferences;

    private static Context mCtx;

    public SharedPrefManager(Context context) {
        mCtx = context;
        mPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
            mPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(UserStudentTop userStudent) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID_NO, userStudent.getIdNo());
        editor.putString(KEY_NAME, userStudent.getName());
        editor.putString(KEY_LOGIN_USER_TYPE, userStudent.getUserType());
        editor.putString(KEY_CAST, userStudent.getCast());
        editor.putString(KEY_RELIGION, userStudent.getReligion());
        editor.putString(KEY_FATHER_NAME, userStudent.getFatherName());
        editor.putString(KEY_MOTHER_NAME, userStudent.getMotherName());
        editor.putString(KEY_GENDER, userStudent.getGender());
        editor.putString(KEY_ACADEMIC_YEAR, userStudent.getAcademicYear());
        editor.putString(KEY_DOB, userStudent.getDob());
        editor.putString(KEY_BLOOD_GROUP, userStudent.getBloodGroup());
        editor.putString(KEY_STATE, userStudent.getState());
        editor.putString(KEY_NATIONALITY, userStudent.getNationality());
        editor.putString(KEY_ADHAAR_NO, userStudent.getAdhaarNo());
        editor.putString(KEY_CONTACT_NO, userStudent.getContactNo());
        editor.putString(KEY_ADDRESS, userStudent.getAddress());
        editor.putString(KEY_REGISTRATION_NUMBER, userStudent.getRollNo());
        editor.putString(KEY_CLASS, userStudent.getClass_());
        editor.putString(KEY_DIVISION, userStudent.getClass_());
        editor.putString(KEY_ROLL_NO, userStudent.getRollNo());
        editor.putString(KEY_ADMISSION_DATE, userStudent.getAdmissionDate());
        editor.putString(KEY_DP, userStudent.getProfile());
        editor.putString(KEY_SPECIAL_SUBJECT, userStudent.getSpecialSubject());
        editor.putString(KEY_EXPERIANCE, userStudent.getExperience());
        editor.putString(KEY_QUALIFICATION, userStudent.getQualification());
        editor.putString(KEY_REG_DATE, userStudent.getRegDate());
        editor.apply();
        editor.commit();
    }

    public String getLoginUserType()
    {
        return mPreferences.getString(KEY_LOGIN_USER_TYPE,"student");
    }
    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CONTACT_NO, null) != null;
    }

    //this method will give the logged in user
    public UserStudentTop getUserStudent() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

//        String idNo, String userType, String name, String fatherName, String motherName, String dob,
// String _class, String rollNo, String academicYear, String contactNo, String fatherContactNo,
// String bloodGroup, String address, String admissionDate, String cast, String religion,
// String state, String nationality, String adhaarNo, String password, String profile,
// String specialSubject, String experience, String qualification, String regDate

        return new UserStudentTop(sharedPreferences.getString(KEY_ID_NO,""),
                sharedPreferences.getString(KEY_LOGIN_USER_TYPE, "student"),
                sharedPreferences.getString(KEY_NAME, ""),
                sharedPreferences.getString(KEY_FATHER_NAME, ""),
                sharedPreferences.getString(KEY_MOTHER_NAME, ""),
                sharedPreferences.getString(KEY_DOB, ""),
                sharedPreferences.getString(KEY_CLASS, ""),
                sharedPreferences.getString(KEY_ROLL_NO, ""),
                sharedPreferences.getString(KEY_ACADEMIC_YEAR, ""),
                sharedPreferences.getString(KEY_CONTACT_NO, ""),
                sharedPreferences.getString(KEY_FATHER_CONTACT_NO, ""),
                sharedPreferences.getString(KEY_BLOOD_GROUP, ""),
                sharedPreferences.getString(KEY_ADDRESS, ""),
                sharedPreferences.getString(KEY_ADMISSION_DATE, ""),
                sharedPreferences.getString(KEY_CAST, ""),
                sharedPreferences.getString(KEY_RELIGION, ""),
                sharedPreferences.getString(KEY_STATE, ""),
                sharedPreferences.getString(KEY_NATIONALITY, ""),
                sharedPreferences.getString(KEY_ADHAAR_NO, ""),
                sharedPreferences.getString(KEY_DP, ""),
                sharedPreferences.getString(KEY_SPECIAL_SUBJECT, ""),
                sharedPreferences.getString(KEY_QUALIFICATION, ""),
                sharedPreferences.getString(KEY_EXPERIANCE, ""),
                sharedPreferences.getString(KEY_REG_DATE, "")
                );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        //mCtx.startActivity(new Intent(mCtx, MainActivity.class));

    }
    }
