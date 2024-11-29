package com.rolands.sec01;

import com.rolands.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args){
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
                .setName("John Doe")
                .setAge(30)
                .build();

        log.info("{}", person);
    }
}

