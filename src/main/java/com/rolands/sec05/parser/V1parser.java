package com.rolands.sec05.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rolands.models.sec05.v1.Television;
import com.rolands.sec05.V1VersionCompatibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1parser {
    private static final Logger log = LoggerFactory.getLogger(V1VersionCompatibility.class);

    public static void parse(byte[] bytes) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(bytes);

        log.info("{}",tv.getBrand());
        log.info("year: {}", tv.getYear());
        log.info("brand: {}", tv.getBrand());

//        log.info("smtg: {}", tv.getUnknownFields());
    }
}
