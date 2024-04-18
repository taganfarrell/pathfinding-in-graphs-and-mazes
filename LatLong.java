public class LatLong {
    private double latitude;
    private double longitude;

    public LatLong(int degLat, int minLat, int secLat, char dirLat,
                   int degLon, int minLon, int secLon, char dirLon) {
        this.latitude = convertDMSToDecimal(degLat, minLat, secLat, dirLat);
        this.longitude = convertDMSToDecimal(degLon, minLon, secLon, dirLon);
    }

    // Helper method to convert DMS to decimal degrees
    private double convertDMSToDecimal(int degrees, int minutes, int seconds, char direction) {
        double decimal = degrees + (minutes / 60.0) + (seconds / 3600.0);
        if (direction == 'S' || direction == 'W') {
            decimal *= -1;
        }
        return decimal;
    }

    // Method to calculate distance between two LatLong objects using the Haversine formula
    public double distanceTo(LatLong other) {
        final double earthRadiusKm = 6371.0; // Earth's radius in kilometers

        double latDistance = Math.toRadians(other.latitude - this.latitude);
        double lonDistance = Math.toRadians(other.longitude - this.longitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(other.latitude)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadiusKm * c; // Distance in kilometers
    }

    // Getters for latitude and longitude
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // toString method for displaying the coordinates
    @Override
    public String toString() {
        return "LatLong{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

