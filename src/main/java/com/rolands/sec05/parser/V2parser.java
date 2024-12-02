package com.rolands.sec05.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rolands.models.sec05.v2.Television;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2parser {
    private static final Logger log = LoggerFactory.getLogger(V2parser.class);

    public static void parse(byte[] bytes) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(bytes);

        log.info("{}",tv.getBrand());
        log.info("year: {}", tv.getModel());
        log.info("type: {}", tv.getType());
        log.info("brand: {}", tv.getBrand());
    }
}
