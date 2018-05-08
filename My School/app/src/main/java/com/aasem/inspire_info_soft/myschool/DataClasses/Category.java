package com.aasem.inspire_info_soft.myschool.DataClasses;

import java.util.Date;

/**
 * Created by inspire_info_soft on 1/26/2018.
 */

public class Category {
    int category_id;
    String name,enable;
    int image;
    Date date_creation;
    Date timestamp;

    public Category(int category_id, String name, int image) {
        this.category_id = category_id;
        this.name = name;
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
