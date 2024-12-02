package com.rolands.sec05.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rolands.models.sec05.v3.Television;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V3parser {
    private static final Logger log = LoggerFactory.getLogger(V3parser.class);

    public static void parse(byte[] bytes) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(bytes);
        log.info("{}",tv.getBrand());
        log.info("type: {}", tv.getType());
        log.info("brand: {}", tv.getBrand());
    }
}
