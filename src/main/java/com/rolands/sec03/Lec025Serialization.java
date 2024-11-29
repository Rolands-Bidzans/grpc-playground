package com.rolands.sec03;

import com.rolands.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec025Serialization {

    private static final Logger log = LoggerFactory.getLogger(Lec025Serialization.class);
    private static final Path PATH = Path.of("person.out");
    public static void main(String... args) throws IOException {
        var person = Person.newBuilder()
//                .setLastName("sam") // in proto file last_name, but in Java lastName
//                .setAge(12)
                .setEmail("sam@email.com")
//                .setEmployed(true)
//                .setSalary(1000.12) // commented out will not be present in proto -> will not display as null
//                .setBankAccountNumber(123456789012L)
//                .setBalance(-10000)
                .build();

        /*
            {
                "employed": true
            }
         */
        serialize(person);
        log.info("{}", deserialize());
        log.info("equals: {}", person.equals(deserialize()));
        log.info("bytes length: {}", person.toByteArray().length);
    }

    public static void serialize(Person person) throws IOException {
        try(var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
//        person.writeTo(Files.newOutputStream(PATH));
    }

    public static Person deserialize() throws IOException {
        try(var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
//        return Person.parseFrom(Files.newInputStream(PATH));
    }
}
