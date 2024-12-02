package com.rolands.sec04;

import com.rolands.models.sec04.Person;
import com.rolands.models.sec04.common.Address;
import com.rolands.models.sec04.common.BodyStyle;
import com.rolands.models.sec04.common.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Import {
    private static final Logger log = LoggerFactory.getLogger(Lec01Import.class);

    public static void main(String... args) {
        var address = Address.newBuilder().setCity("atlanta").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();

        var person = Person.newBuilder()
                .setName("sam")
                .setAge(12)
                .setCar(car)
                .setAddress(address)
                .build();


    }
}
