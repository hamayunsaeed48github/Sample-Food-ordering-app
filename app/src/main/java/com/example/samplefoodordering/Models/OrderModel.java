package com.example.samplefoodordering.Models;

public class OrderModel {
    int orderimage;
    String ordername,ordernumber,oprice,quantity;

    public OrderModel(){

    }

    public OrderModel(int orderimage, String ordername, String ordernumber, String oprice,String quantity) {
        this.orderimage = orderimage;
        this.ordername = ordername;
        this.ordernumber = ordernumber;
        this.oprice = oprice;
        this.quantity=quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getOprice() {
        return oprice;
    }

    public void setOprice(String oprice) {
        this.oprice = oprice;
    }
}
