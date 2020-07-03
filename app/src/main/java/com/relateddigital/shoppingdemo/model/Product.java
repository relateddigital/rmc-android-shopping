package com.relateddigital.shoppingdemo.model;


import java.io.Serializable;


public class Product implements Serializable {

    private String name, content, price;
    private int pic, id;

    public Product(int id, String name, String content, int pic, String price){

        this.id = id;
        this.name = name;
        this.content = content;
        this.pic = pic;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }
}