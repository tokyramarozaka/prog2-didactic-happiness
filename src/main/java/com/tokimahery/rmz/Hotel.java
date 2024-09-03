package com.tokimahery.rmz;

import java.util.List;
import java.util.Objects;

public class Hotel extends Place {
    private String phone;
    private String email;
    private List<Review> hotelReviews;
    private List<Room> rooms;

    public Hotel(String name, double latitude, double longitude, String description, List<Review> placeReviews,
                 String phone, String email, List<Review> hotelReviews, List<Room> rooms) {
        super(name, latitude, longitude, description, placeReviews);
        this.phone = phone;
        this.email = email;
        this.hotelReviews = hotelReviews;
        this.rooms = rooms;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getHotelReviews() {
        return hotelReviews;
    }

    public void setHotelReviews(List<Review> hotelReviews) {
        this.hotelReviews = hotelReviews;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(phone, hotel.phone) && Objects.equals(email, hotel.email)
                && Objects.equals(hotelReviews, hotel.hotelReviews) && Objects.equals(rooms, hotel.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, email, hotelReviews, rooms);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", hotelReviews=" + hotelReviews +
                ", rooms=" + rooms +
                '}';
    }
}
