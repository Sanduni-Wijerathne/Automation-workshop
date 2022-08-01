package com.rootcode;

public class findTotal {
    public static void main(String[] args) {
        String price1 = "10.5";
        String price2 = "12.5";
        String total = price1 + price2;

        float totalPrice = Float.parseFloat(price1) + Float.parseFloat(price2);

        System.out.println("Total is USD " + totalPrice);
    }
}
