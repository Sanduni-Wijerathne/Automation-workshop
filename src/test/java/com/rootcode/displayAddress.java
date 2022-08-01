package com.rootcode;

public class displayAddress {
    public static void main(String[] args) {
        String house_number = "528/2";
        String street_name = "Galapitiyagama";
        String town_name = "Nikaweratiya";

        String address = getAddress(house_number,street_name,town_name);
        System.out.println("Address: " + address);

    }

    private static String getAddress(String house_number,String street_name,String town_name){
        String address = String.format("%s %s %s",house_number,street_name,town_name);
        return address;
    }
}

