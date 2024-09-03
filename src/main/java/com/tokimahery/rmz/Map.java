package com.tokimahery.rmz;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Park> parks;

    public Map(List<Park> parks) {
        this.parks = parks;
    }

    public List<Park> getParks() {
        return parks;
    }

    public void setParks(List<Park> parks) {
        this.parks = parks;
    }

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();

        for (Park park : this.parks) {
            reviews.addAll(park.getReviews());
            for (Hotel nearbyHotel : park.getNearbyHotels()) {
                reviews.addAll(nearbyHotel.getReviews());
                for (Room room : nearbyHotel.getRooms()) {
                    reviews.addAll(room.getReviews());
                }
            }
        }

        return reviews;
    }

    public Hotel findBestHotel() { // this can actually be very easy, if we assume that hotel have nearby parks instead
        Hotel bestHotel = null;
        int currentMaxParks = 0;

        for (Park park : this.parks) {
            for (Hotel hotel : park.getNearbyHotels()) {
                int nearbyParks = countNearbyParks(hotel);

                if (bestHotel == null || nearbyParks > currentMaxParks){
                    bestHotel = hotel;
                } else if (nearbyParks == currentMaxParks){
                    if (Math.random() > 0.5){ // not really necessary but we can randomize the choice.
                        bestHotel = hotel;
                    }
                }
            }
        }

        return bestHotel;
    }

    public int countNearbyParks(Hotel hotel) {
        int count = 0;

        for (Park park : this.parks) {
            if(park.getNearbyHotels().contains(hotel)){
                count++;
            }
        }

        return count;
    }

    public List<Place> getAllPlacesInside(double longitudeMin, double longitudeMax, double latitudeMin,
                                          double latitudeMax ) {
        List<Place> placesInside = new ArrayList<>();

        for (Park park : this.parks) {
            if (isWithin(park, longitudeMin, longitudeMax, latitudeMin, latitudeMax)){
                placesInside.add(park);
            }

            for (Hotel hotel : park.getNearbyHotels()) {
                if (isWithin(hotel, longitudeMin, longitudeMax, latitudeMin, latitudeMax)){
                    placesInside.add(park);
                }
            }
        }
        return placesInside;
    }

    public boolean isWithin(Place place, double longitudeMin, double longitudeMax, double latitudeMin,
                             double latitudeMax) {
        return place.getLongitude() >= longitudeMin && place.getLongitude() <= longitudeMax
                && place.getLatitude() >= latitudeMin && place.getLatitude() <= latitudeMax;
    }

    public double findCheapestHotelPrice(List<Park> parksToTravel){
        double cheapestHotelPrice = 0.0;

        for (Park park : parksToTravel) {
            cheapestHotelPrice += park.getCheapestRoomPrice();
        }

        return cheapestHotelPrice;
    }

    public List<Reviewable> getAllReviewedItems(){
        List<Reviewable> reviewedItems = new ArrayList<>();

        for (Park park : this.parks) {
            if (!park.getReviews().isEmpty()) {
                reviewedItems.add(park);
            }

            for (Hotel hotel : park.getNearbyHotels()) {
                if (!hotel.getReviews().isEmpty()) {
                    reviewedItems.add(hotel);
                }

                for(Room room : hotel.getRooms()){
                    if (!room.getReviews().isEmpty()) {
                        reviewedItems.add(room);
                    }
                }
            }
        }

        return reviewedItems;
    }
}
