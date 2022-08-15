package com.jarekjal.protobuf;

import com.google.protobuf.TextFormat;
import com.jarekjal.models.Address;
import com.jarekjal.models.Car;
import com.jarekjal.models.Person;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setCity("Dąbrowa Górnicza")
                .setStreet("3. Powstania Śląskiego 3/8")
                .setPostbox(41303)
                .build();
        Car car = Car.newBuilder()
                .setMake("Nissan")
                .setModel("Micra")
                //.setYear(2015)
                .build();
        Person jarek = Person.newBuilder()
                .setName("Jarosław Jałoszyński")
                .setAge(42)
                .setAddress(address)
                .addAllCar(List.of(car))
                .build();

        System.out.println(jarek);
        Path path = Paths.get("person.ser");
        try {
            Files.write(path, jarek.toByteArray());
            byte[] bytes = Files.readAllBytes(path);
            Person newJarek = Person.parseFrom(bytes);
            System.out.println(TextFormat.printer().escapingNonAscii(false).printToString(newJarek));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
