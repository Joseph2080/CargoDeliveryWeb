package com.example.cargodeliveryweb.Model.Cargo;


import java.util.Arrays;
import java.util.Date;

public class Cargo {

    private int cargoId;
    private String cargoType;
    private double weight;
    private double volume;
    private Date deliveryDate;
    private String address[];

    public Cargo(int cargoId, String cargoType, double weight, double volume, Date deliveryDate,String street,String town,String country,String postCode) {
        this.cargoId = cargoId;
        this.cargoType = cargoType;
        this.weight = weight;
        this.volume = volume;
        this.deliveryDate = deliveryDate;
        address = new String[4];
        address[0] = street;
        address[1] = town;
        address[2] = country;
        address[3] = postCode;
    }

    public Cargo(String cargoType, double weight, double volume, Date deliveryDate,String street,String town,String country,String postCode) {
        this.cargoType = cargoType;
        this.weight = weight;
        this.volume = volume;
        this.deliveryDate = deliveryDate;
        this.address = address;
        address = new String[4];
        address[0] = street;
        address[1] = town;
        address[2] = country;
        address[3] = postCode;
    }

    public Cargo(){
        cargoId = -1;
        cargoType = "none";
        weight = -1.0;
        volume = -1.0;
        deliveryDate = null;
        address = new String[4];
        address[0] = "no street available";
        address[1] = "no town available";
        address[2] = "no country available";
        address[3] = "no postal number";
    }


    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String[] getAddressArr() {
        return address;
    }

    public String getAddress(){
        return address[0] + ", " + address[1] + ", " + address[2] + " " + address[3];
    }

    public void setAddress(String street,String town,String country,String postCode) {
        address = new String[4];
        address[0] = "no street available";
        address[1] = "no town available";
        address[2] = "no country available";
        address[3] = "no postal number";
    }

    public String getStreet(){
        return address[0];
    }

    public String getTown(){
        return address[1];
    }

    public String getCountry(){
        return address[2];
    }

    public String getPostalCode(){
        return address[3];
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoId=" + cargoId +
                ", cargoType='" + cargoType + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", deliveryDate=" + deliveryDate.toString() +
                ", address=" + Arrays.toString(address) +
                '}';
    }
}
