package com.sstgroup.petrolstation;

public class Person {
    private int id;
    String product,station_location,date,time,price,quantity;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setStation_name(String station_name) {
        this.product = station_name;
    }
    public String getStation_name() {
        return product;
    }
    public void setStation_location(String station_location) {
        this.station_location = station_location;
    }
    public String getStation_location() {
        return station_location;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getQuantity() {
        return quantity;
    }
}