package com.rolands.sec05;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rolands.models.sec05.v3.Television;
import com.rolands.models.sec05.v3.Type;
import com.rolands.sec05.parser.V1parser;
import com.rolands.sec05.parser.V2parser;
import com.rolands.sec05.parser.V3parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V3VersionCompatibility {
    private static final Logger log = LoggerFactory.getLogger(V3VersionCompatibility.class);

    public static void main(String... args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
                .setType(Type.UHD)
                .build();

        V1parser.parse(tv.toByteArray());
        V2parser.parse(tv.toByteArray());
        V3parser.parse(tv.toByteArray());
    }
}
