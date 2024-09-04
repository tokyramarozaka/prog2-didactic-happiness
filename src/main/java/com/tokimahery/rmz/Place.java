package com.tokimahery.rmz;

import java.util.List;
import java.util.Objects;

public abstract class Place implements Reviewable {
    private String name;
    private double latitude;
    private double longitude;
    private String description;

    public Place(String name, double latitude, double longitude, String descriptions) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Double.compare(latitude, place.latitude) == 0 && Double.compare(longitude, place.longitude) == 0 &&
                Objects.equals(name, place.name) && Objects.equals(description, place.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude, description);
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", description='" + description + '\'' +
                '}';
    }
}
