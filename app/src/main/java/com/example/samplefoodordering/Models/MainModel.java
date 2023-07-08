package com.example.samplefoodordering.Models;

public class MainModel {
    int foodImage;
    String foodname,orderprice,discription;

    public MainModel(int foodImage, String foodname, String orderprice, String discription) {
        this.foodImage = foodImage;
        this.foodname = foodname;
        this.orderprice = orderprice;
        this.discription = discription;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
