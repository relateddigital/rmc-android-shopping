package com.relateddigital.shoppingdemo.model;


import java.io.Serializable;


public class Product implements Serializable {

    private String Name, Brand, price;
    private String Image, ID;

    public Product(String ID, String name, String Brand, String  Image, String DiscountedPrice){

        this.ID = ID;
        this.Name = name;
        this.Brand = Brand;
        this.Image = Image;
        this.price = DiscountedPrice;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String  image) {
        this.Image = image;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getID() {
        return String.valueOf(ID);
    }

    public void setID(String  ID) {
        this.ID = ID;
    }
}