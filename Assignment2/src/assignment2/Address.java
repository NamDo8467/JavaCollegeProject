/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author huynh
 */
public class Address {
    public  String streetInfo1;
    public String streetInfo2;
    public String city;
    public String postalCode;
    public String country;
    
    public Address(String streetInfo1, String streetInfo2, String city, String postalCode, String country){
        this.streetInfo1 = streetInfo1;
        this.streetInfo2 = streetInfo2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
                
    }
    
    @Override
    public String toString(){
        String s = "Street Information 1: " + streetInfo1 + "\n";
        s += "Street Information 2: " + streetInfo2 + "\n";
        s += "City: " + city + "\n";
        s += "Postal Code: " + postalCode + "\n";
        s += "Country: " + country + "\n";
        return s;
    }
}
