package com.jarekjal.protobuf;

import com.google.protobuf.Int32Value;
import com.jarekjal.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {
    public static void main(String[] args) throws IOException {

        Person sam = Person.newBuilder()
                .setName("Sam")
                .setAge(Int32Value.newBuilder().setValue(10).build())
                .build();

        Path path = Paths.get("sam.ser");
        Files.write(path, sam.toByteArray());
        byte[] bytes = Files.readAllBytes(path);
        Person deserializedPerson = Person.parseFrom(bytes);
        System.out.println(deserializedPerson);
    }
}
