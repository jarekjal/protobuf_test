package com.jarekjal.protobuf;

import com.jarekjal.models.Car;
import com.jarekjal.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {

        Car micra = Car.newBuilder()
                .setMake("Nissan")
                .setModel("Micra")
                .setYear(2015)
                .build();
        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2008)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(5, micra)
                .putModel(2, civic)
                .build();

        System.out.println(dealer.getModelOrThrow(2).getBodyStyle());

    }
}
