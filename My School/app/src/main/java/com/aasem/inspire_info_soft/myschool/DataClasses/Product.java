package com.aasem.inspire_info_soft.myschool.DataClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by inspire_info_soft on 1/20/2018.
 */

public class Product {

    int product_id,user_id;
    int catgory_id;
    String name;
    float original_price,selling_price;

    String description,contact_no,email_id,location,address,enable;
    Date date_creation,date_expiry;
    ArrayList<String> product_image;
    float rating;
    String verified;

    public Product(int product_id, String name, float selling_price, String location, Date date_creation, float rating, String verified) {
        this.product_id = product_id;
        this.name = name;
        this.selling_price = selling_price;
        this.location = location;
        this.date_creation = date_creation;
        this.rating = rating;
        this.verified = verified;
    }

    public Product(int product_id, int user_id, int catgory_id, String name, float original_price, float selling_price, String description, String contact_no, String email_id, String location, String address, String enable, Date date_creation, Date date_expiry, ArrayList<String> product_image, float rating, String verified) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.catgory_id = catgory_id;
        this.name = name;
        this.original_price = original_price;
        this.selling_price = selling_price;
        this.description = description;
        this.contact_no = contact_no;
        this.email_id = email_id;
        this.location = location;
        this.address = address;
        this.date_creation = date_creation;
        this.date_expiry = date_expiry;
        this.product_image = product_image;
        this.rating = rating;
        this.verified = verified;
    }

    public int getCatgory_id() {
        return catgory_id;
    }

    public void setCatgory_id(int catgory_id) {
        this.catgory_id = catgory_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(float original_price) {
        this.original_price = original_price;
    }

    public float getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public String getDisplayableTime()
    {
        long delta=getDate_creation().getTime();
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
        return null;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_expiry() {
        return date_expiry;
    }

    public void setDate_expiry(Date date_expiry) {
        this.date_expiry = date_expiry;
    }

    public ArrayList<String> getProduct_image() {
        return product_image;
    }

    public void setProduct_image(ArrayList<String> product_image) {
        this.product_image = product_image;
    }

}