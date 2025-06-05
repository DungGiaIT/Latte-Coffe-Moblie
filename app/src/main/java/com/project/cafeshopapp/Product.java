package com.project.cafeshopapp;

public class Product {
    public String id;
    public String title;
    public String description;
    public double price;
    public double originalPrice;
    public double rating;
    public int reviews;
    public String image;
    public String size;
    public String milk;
    public String type;

    public Product(String type, String milk, String size, String image, int reviews, double rating, double originalPrice, double price, String description, String title, String id) {
        this.type = type;
        this.milk = milk;
        this.size = size;
        this.image = image;
        this.reviews = reviews;
        this.rating = rating;
        this.originalPrice = originalPrice;
        this.price = price;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
