package com.example.shared.hackathon;



public class GuideListDataClass {

    String name,lan,price,contact;
    int photo;

    public GuideListDataClass() {
    }

    public GuideListDataClass(String name, String lan, String price, String contact, int photo) {
        this.name = name;
        this.lan = lan;
        this.price = price;
        this.contact = contact;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
