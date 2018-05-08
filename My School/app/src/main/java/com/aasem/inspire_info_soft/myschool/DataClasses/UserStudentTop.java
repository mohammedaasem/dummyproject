package com.aasem.inspire_info_soft.myschool.DataClasses;

/**
 * Created by inspire_info_soft on 2/5/2018.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserStudentTop implements Serializable {

    @SerializedName("id_no")
    @Expose
    private String idNo;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("roll_no")
    @Expose
    private String rollNo;
    @SerializedName("academic_year")
    @Expose
    private String academicYear;
    @SerializedName("contact_no")
    @Expose
    private String contactNo;
    @SerializedName("father_contact_no")
    @Expose
    private String fatherContactNo;
    @SerializedName("blood_Group")
    @Expose
    private String bloodGroup;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("admission_date")
    @Expose
    private String admissionDate;
    @SerializedName("cast")
    @Expose
    private String cast;
    @SerializedName("religion")
    @Expose
    private String religion;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("adhaar_no")
    @Expose
    private String adhaarNo;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("special_subject")
    @Expose
    private String specialSubject;
    @SerializedName("experience")
    @Expose
    private String experience;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("reg_date")
    @Expose
    private String regDate;
    private String gender;

    public UserStudentTop(String idNo, String userType, String name, String fatherName, String motherName, String dob, String _class, String rollNo, String academicYear, String contactNo, String fatherContactNo, String bloodGroup, String address, String admissionDate, String cast, String religion, String state, String nationality, String adhaarNo, String profile, String specialSubject, String experience, String qualification, String regDate) {
        this.idNo = idNo;
        this.userType = userType;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dob = dob;
        this._class = _class;
        this.rollNo = rollNo;
        this.academicYear = academicYear;
        this.contactNo = contactNo;
        this.fatherContactNo = fatherContactNo;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.admissionDate = admissionDate;
        this.cast = cast;
        this.religion = religion;
        this.state = state;
        this.nationality = nationality;
        this.adhaarNo = adhaarNo;
        this.profile = profile;
        this.specialSubject = specialSubject;
        this.experience = experience;
        this.qualification = qualification;
        this.regDate = regDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFatherContactNo() {
        return fatherContactNo;
    }

    public void setFatherContactNo(String fatherContactNo) {
        this.fatherContactNo = fatherContactNo;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(String adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSpecialSubject() {
        return specialSubject;
    }

    public void setSpecialSubject(String specialSubject) {
        this.specialSubject = specialSubject;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

}
