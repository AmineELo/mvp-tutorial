package com.teemotech.mvp_tutorial.mainscreen.model;

public class RandomUser {

    private String imageUrl, name, email;

    public RandomUser() {
    }

    public RandomUser(String imageUrl, String name, String email) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
