package com.example.sneha.myapplication;

public class Model {

    boolean isTextShow=false;
    int img;

    public Model(boolean isTextShow,int img) {
        this.isTextShow = isTextShow;
        this.img=img;
    }

    public boolean isTextShow() {
        return isTextShow;
    }

    public void setTextShow(boolean textShow) {
        isTextShow = textShow;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
