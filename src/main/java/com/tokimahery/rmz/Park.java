package com.tokimahery.rmz;

import java.util.List;
import java.util.Objects;

public class Park extends Place implements Reviewable {
    private List<Hotel> nearbyHotels;
    private List<Review> reviews;

    public Park(String name, double latitude, double longitude, String description, List<Review> reviews,
                List<Hotel> nearbyHotels) {
        super(name, latitude, longitude, description);
        this.nearbyHotels = nearbyHotels;
        this.reviews = reviews;
    }

    public List<Hotel> getNearbyHotels() {
        return nearbyHotels;
    }

    public void setNearbyHotels(List<Hotel> nearbyHotels) {
        this.nearbyHotels = nearbyHotels;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public List<Review> getReviews() {
        return this.reviews;
    }

    @Override
    public void addReview(Review toAdd) {
        this.reviews.add(toAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Park park = (Park) o;
        return Objects.equals(nearbyHotels, park.nearbyHotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nearbyHotels);
    }

    public double getCheapestRoomPrice() {
        double cheapestRoomPrice = Double.MAX_VALUE;

        for (Hotel hotel : this.nearbyHotels) {
            for (Room room : hotel.getRooms()) {
                if(room.getPricePerNight() > cheapestRoomPrice) {
                    cheapestRoomPrice = room.getPricePerNight();
                }
            }
        }

        return cheapestRoomPrice;
    }
}
