package com.example.electrogoods;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class IklanModel {

    public String category, pilihan, merk, title, describe, price, name, phone, location, imageurl;

    public IklanModel(){

    }

    public IklanModel(String category, String pilihan, String merk, String title,
                      String describe, String price, String name, String phone, String location, String imageurl) {
        this.category = category;
        this.pilihan = pilihan;
        this.merk = merk;
        this.title = title;
        this.describe = describe;
        this.price = price;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.imageurl = imageurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
