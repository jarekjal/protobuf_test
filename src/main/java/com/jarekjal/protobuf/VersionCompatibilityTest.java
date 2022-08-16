package com.jarekjal.protobuf;

import com.jarekjal.models.Television;
//import com.jarekjal.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

      /*  Television television = Television.newBuilder()
                .setBrand("Sony")
                .setModel(2016)
                .setType(Type.OLED)
                .build();

        Path pathV1 = Paths.get("tv-v1.ser");
        Path pathV2 = Paths.get("tv-v2.ser");
        Files.write(pathV2, television.toByteArray());*/

        Path pathV1 = Paths.get("tv-v1.ser");
        Path pathV2 = Paths.get("tv-v2.ser");
        byte[] bytes = Files.readAllBytes(pathV2);
        System.out.println(
                Television.parseFrom(bytes)
        );

    }

}
