package com.hegazy.returnees;


import java.io.Serializable;

public class Data implements Serializable {
    String subject1;
    Integer[] images;

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public Integer[] getImages() {
        return images;
    }

    public void setImages(Integer[] images) {
        this.images = images;
    }


    public Data(String subject1, Integer[] images) {
        this.subject1 = subject1;
        this.images = images;
    }
}