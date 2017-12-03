package com.example.shared.hackathon;


public class PlacesListDataClass {

    String name;
    int image;

    public PlacesListDataClass(String name, int image) {
        this.name = name;

        this.image = image;
    }

    public PlacesListDataClass() {
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
