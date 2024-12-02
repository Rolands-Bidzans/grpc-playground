package com.rolands.sec05;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rolands.models.sec05.v2.Television;
import com.rolands.models.sec05.v2.Type;
import com.rolands.sec05.parser.V1parser;
import com.rolands.sec05.parser.V2parser;
import com.rolands.sec05.parser.V3parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2VersionCompatibility {
    private static final Logger log = LoggerFactory.getLogger(V2VersionCompatibility.class);

    public static void main(String... args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
                .setModel(2019)
                .setType(Type.UHD)
                .build();

        V1parser.parse(tv.toByteArray());
        V2parser.parse(tv.toByteArray());
        V3parser.parse(tv.toByteArray());
    }
}