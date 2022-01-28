package com.example.cargodeliveryweb.Model.Cargo;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Cargo {

    private int cargoId;
    private String cargoType;
    private double weight;
    private double volume;
    private Date deliveryDate;
    private String address[];
    private boolean delivered;
    private boolean confirmed;
    private int userId;

    public Cargo(int cargoId, String cargoType, double weight, double volume, Date deliveryDate,String street,String town,String country,String postCode,boolean delivered,boolean confirmed,int userId) {
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
        this.delivered = delivered;
        this.confirmed = confirmed;
        this.userId = userId;
    }

    public Cargo(int cargoId, String cargoType, double weight, double volume, Date deliveryDate,String street,String town,String country,String postCode,boolean delivered,boolean confirmed) {
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
        this.delivered = delivered;
        this.confirmed = confirmed;
        this.userId = userId;
    }

    public Cargo(String cargoType, double weight, double volume, Date deliveryDate,String street,String town,String country,String postCode,boolean delivered,boolean confirmed,int userId) {
        this.cargoType = cargoType;
        this.weight = weight;
        this.volume = volume;
        this.deliveryDate = deliveryDate;
        address = new String[4];
        address[0] = street;
        address[1] = town;
        address[2] = country;
        address[3] = postCode;
        this.delivered = delivered;
        this.confirmed = confirmed;
        this.userId = userId;
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
        delivered = false;
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

    public boolean isDelivered(){
        return delivered;
    }

    public void setDelivered(boolean delivered){
        this.delivered = delivered;
    }

    public int getUserId(){
        return userId;
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
                ", delivered=" + delivered +
                '}';
    }

    public static Comparator<Cargo> compareById = new Comparator<Cargo>() {
        @Override
        public int compare(Cargo o1, Cargo o2) {
            return Integer.compare(o1.getCargoId(),o2.getCargoId());
        }
    };

    public static Comparator<Cargo> compareByType = new Comparator<Cargo>() {
        @Override
        public int compare(Cargo o1, Cargo o2) {
            return o1.getCargoType().compareTo(o2.getCargoType());
        }
    };

    public static Comparator<Cargo> compareByCountry = new Comparator<Cargo>() {
        @Override
        public int compare(Cargo o1, Cargo o2) {
            return o1.getCountry().compareTo(o2.getCountry());
        }
    };


    public static double calculateDelivery(String type,double weight,double volume,String country){

        boolean isEurope = checkCargoCountry(country);
        double cost = (volume*weight)*0.15;
        if(isEurope){
            cost = (volume*weight)*0.1;
        }
        if(type.equalsIgnoreCase("container")){
            cost += 250;
        }
        if(type.equalsIgnoreCase("liquid-bulk")){
            cost += 150;
        }
        if(type.equalsIgnoreCase("dry-bulk")){
            cost +=180;
        }
        return cost;
    }

    private static boolean checkCargoCountry(String country){
        String eu_countries[] = {"Albania",
                "Andorra",
                "Armenia",
                "Austria",
                "Azerbaijan",
                "Belarus",
                "Belgium",
                "Bosnia and Herzegovina",
                "Bulgaria",
                "Croatia",
                "Cyprus",
                "Czech Republic",
                "Denmark",
                "Estonia",
                "Finland",
                "France",
                "Georgia",
                "Germany",
                "Greece",
                "Hungary",
                "Iceland",
                "Ireland",
                "Italy",
                "Kosovo",
                "Latvia",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg",
                "Macedonia",
                "Malta",
                "Moldova",
                "Monaco",
                "Montenegro",
                "The Netherlands",
                "Norway",
                "Poland",
                "Portugal",
                "Romania",
                "Russia",
                "San Marino",
                "Serbia",
                "Slovakia",
                "Slovenia",
                "Spain",
                "Sweden",
                "Switzerland",
                "Turkey",
                "Ukraine",
                "United Kingdom",
                "Vatican City"};
        for(String c:eu_countries){
            if(c.equalsIgnoreCase(country)){
                return true;
            }
        }
        return false;
    }
}
