
package com.mycompany.supermarket;


public class Location {

    private String city;
    private String street;
    private int houseNumber;

    public Location (String city, String street, int houseNumper) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumper;
    }
    public Location(){
     this("", "", 0);   
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumper() {
        return houseNumber;
    }

    public void setHouseNumper(int houseNumper) {
        this.houseNumber = houseNumper;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", street=" + street + ", houseNumber=" + houseNumber + '}';
    }
    
}
