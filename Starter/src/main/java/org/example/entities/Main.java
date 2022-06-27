package org.example.entities;


import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        BigDecimal start = new BigDecimal(45000);
        Byte rated = 7;

        BigDecimal rate = new BigDecimal(rated);
         start = start.subtract(start.multiply(rate).divide(new BigDecimal(100)));
        System.out.println( "" + start);
    }
}
