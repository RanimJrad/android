package com.example.miniprojetand;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private String id;                   // Unique identifier for Firebase
    private String name;
    private String location;
    private String price;
    private String mainImageUrl;         // URL for the main image
    private ArrayList<String> additionalPhotos;  // List of URLs for additional photos

    // No-argument constructor required for Firebase
    public Hotel() {}

    public Hotel(String id, String name, String location, String price, String mainImageUrl, ArrayList<String> additionalPhotos) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.mainImageUrl = mainImageUrl;
        this.additionalPhotos = additionalPhotos;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }
    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public ArrayList<String> getAdditionalPhotos() {
        return additionalPhotos;
    }
    public void setAdditionalPhotos(ArrayList<String> additionalPhotos) {
        this.additionalPhotos = additionalPhotos;
    }
}
