package com.relateddigital.shoppingdemo.model;


import java.io.Serializable;


public class Product implements Serializable {

    private String name, content,year;
    private int pic;

    public Product(String name, String content, int pic){

        this.name = name;
        this.content = content;
        this.pic = pic;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}