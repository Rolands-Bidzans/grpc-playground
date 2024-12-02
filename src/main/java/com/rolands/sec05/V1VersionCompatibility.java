package com.rolands.sec05;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rolands.models.sec05.v1.Television;
import com.rolands.sec05.parser.V1parser;
import com.rolands.sec05.parser.V2parser;
import com.rolands.sec05.parser.V3parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1VersionCompatibility {
    private static final Logger log = LoggerFactory.getLogger(V1VersionCompatibility.class);

    public static void main(String... args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
                .setYear(2019)
                .build();

        V1parser.parse(tv.toByteArray());
        V2parser.parse(tv.toByteArray());
        V3parser.parse(tv.toByteArray());
    }
}
