package com.tokimahery.rmz;

import java.time.LocalDate;

public class Review {
    private User user;
    private int rating;
    private String description;
    private LocalDate date;

    public Review(User user, int rating, String description, LocalDate date) {
        this.user = user;
        this.rating = rating;
        this.description = description;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
