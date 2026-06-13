package za.ac.cput.domain;

import java.time.LocalDateTime;

public class Location {
    private double latitude;
    private double longitude;
    private String address;
    private LocalDateTime timestamp;

    protected Location() {}

    private Location(Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.address = builder.address;
        this.timestamp = builder.timestamp;
    }

    // Getters
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getAddress() { return address; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Haversine formula for distance calculation between two points in kilometers
    public double calculateDistance(Location to) {
        final int EARTH_RADIUS_KM = 6371;

        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(to.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lon2 = Math.toRadians(to.longitude);

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    public boolean isWithinRadius(Location center, double radius) {
        return calculateDistance(center) <= radius;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private double latitude;
        private double longitude;
        private String address;
        private LocalDateTime timestamp = LocalDateTime.now();

        public Builder setLatitude(double latitude) { this.latitude = latitude; return this; }
        public Builder setLongitude(double longitude) { this.longitude = longitude; return this; }
        public Builder setAddress(String address) { this.address = address; return this; }
        public Builder setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; return this; }

        public Location build() { return new Location(this); }
    }
}
