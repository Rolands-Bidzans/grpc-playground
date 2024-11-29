package com.rolands.sec02;

import com.rolands.models.sec02.Person;
import com.rolands.sec01.SimpleProtoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);


    public static void main(String[] args){
        //Create person 1
        var person1 = createPerson();

        //Create another instance with some values
        var person2 = createPerson();

        //compare
        log.info("equals {}", person1.equals(person2)); // checks fields
        log.info("== {}", person1 == person2); // checks references

        // mutable? No, you can build another one

        //create another instance with diff values
        var person3 = person1.toBuilder().setName("mike").build();

        //compare
        log.info("equals {}", person1.equals(person3));
        log.info("== {}", person1 == person3);

        //null??
//        var person4 = person1.toBuilder().setName(null).build();  // NULL EXCEPTION
        var person4 = person1.toBuilder().clearName().build();
        log.info("person4: {}", person4);
    }

    private static Person createPerson(){
        return Person.newBuilder()
                .setName("sam")
                .setAge(12)
                .build();
    }
}

