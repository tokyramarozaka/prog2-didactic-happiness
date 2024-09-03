package com.tokimahery.rmz;

import java.util.List;

public class Room implements Reviewable {
    private String number; // sometimes they put weird things like A107 here
    private double pricePerNight;
    private List<Review> roomReviews;

    public Room(String number, double pricePerNight, List<Review> roomReviews) {
        this.number = number;
        this.pricePerNight = pricePerNight;
        this.roomReviews = roomReviews;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<Review> getRoomReviews() {
        return roomReviews;
    }

    public void setRoomReviews(List<Review> roomReviews) {
        this.roomReviews = roomReviews;
    }

    @Override
    public void addReview(Review toAdd) {
        this.roomReviews.add(toAdd);
    }

    @Override
    public List<Review> getReviews() {
        return this.roomReviews;
    }
}
