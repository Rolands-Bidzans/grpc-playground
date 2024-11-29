package com.rolands.sec03;


import com.rolands.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args){
        var person = Person.newBuilder()
                .setLastName("sam") // in proto file last_name, but in Java lastName
                .setAge(12)
                .setEmail("sam@email.com")
//                .setEmployed(true)
//                .setSalary(1000.12) // commented out will not be present in proto -> will not display as null
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        log.info("{}", person);
    }
}
