package com.aasem.inspire_info_soft.myschool.DataClasses;

/**
 * Created by inspire_info_soft on 2/12/2018.
 */

public class StaffData {
    String facultyName,facultyQualification,facultyExperience,facultySubject;
    int profileImage;

    public StaffData(String facultyName, String facultyQualification, String facultyExperience, String facultySubject, int profileImage) {
        this.facultyName = facultyName;
        this.facultyQualification = facultyQualification;
        this.facultyExperience = facultyExperience;
        this.facultySubject = facultySubject;
        this.profileImage = profileImage;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyQualification() {
        return facultyQualification;
    }

    public void setFacultyQualification(String facultyQualification) {
        this.facultyQualification = facultyQualification;
    }

    public String getFacultyExperience() {
        return facultyExperience;
    }

    public void setFacultyExperience(String facultyExperience) {
        this.facultyExperience = facultyExperience;
    }

    public String getFacultySubject() {
        return facultySubject;
    }

    public void setFacultySubject(String facultySubject) {
        this.facultySubject = facultySubject;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }
}
