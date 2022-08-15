package com.jarekjal.protobuf;

import com.jarekjal.models.Credential;

public class OneOfDemo {

    public static void main(String[] args) {

        Credential credential = Credential.newBuilder()
                .setCode(666)

                .build();

        System.out.println(
                credential
        );
    }
}
