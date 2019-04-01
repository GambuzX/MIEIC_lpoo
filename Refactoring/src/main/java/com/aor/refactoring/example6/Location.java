package com.aor.refactoring.example6;

public class Location {
    public String latitude;
    public String longitude;
    public String name;
    public Location(String l1, String l2, String n) {
        latitude = l1;
        longitude = l2;
        name = n;
    }
    public String toString() {
        return this.latitude + "," + this.longitude + " (" + this.name + ")";
    }

    public void setLocation(String lat, String lon, String n) {
        latitude = lat;
        longitude = lon;
        name = n;
    }
}
