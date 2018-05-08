package com.aasem.inspire_info_soft.myschool.DataClasses;

import android.widget.EditText;

/**
 * Created by inspire_info_soft on 2/4/2018.
 */

public class UserStudent {
    String Name, FatherName, MotherName, Gender, DOB, ContactNumber, BloodGroup, AdhaarNumber, Address, RegistrationNumber, mClass, Division, RollNumber;

    public UserStudent(String name, String fatherName, String motherName, String gender, String DOB, String contactNumber, String bloodGroup, String adhaarNumber, String address, String registrationNumber, String mClass, String division, String rollNumber) {
        Name = name;
        FatherName = fatherName;
        MotherName = motherName;
        Gender = gender;
        this.DOB = DOB;
        ContactNumber = contactNumber;
        BloodGroup = bloodGroup;
        AdhaarNumber = adhaarNumber;
        Address = address;
        RegistrationNumber = registrationNumber;
        mClass = mClass;
        Division = division;
        RollNumber = rollNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getAdhaarNumber() {
        return AdhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        AdhaarNumber = adhaarNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }


    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }
}
