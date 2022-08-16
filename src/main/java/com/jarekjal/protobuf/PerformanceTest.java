package com.jarekjal.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.jarekjal.json.JPerson;
import com.jarekjal.models.Person;

public class PerformanceTest {

    public static void main(String[] args) {
        JPerson samJSON = new JPerson();
        samJSON.setName("sam");
        samJSON.setAge(10);
        ObjectMapper mapper = new ObjectMapper();
        Runnable serializeJSON = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(samJSON);
                JPerson newSam = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Person samProto = Person.newBuilder()
                .setName("sam")
                .setAge(Int32Value.newBuilder().setValue(10).build())
                .build();
        Runnable serializeProtoBuf = () -> {
            byte[] bytes = samProto.toByteArray();
            try {
                Person newSam = Person.parseFrom(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(serializeJSON, "JSON");
            runPerformanceTest(serializeProtoBuf, "PROTO");
        }

    }

    private static void runPerformanceTest(Runnable runnable, String name) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        long end = System.currentTimeMillis();
        System.out.println(name + " : " + (end - start));
    }
}
