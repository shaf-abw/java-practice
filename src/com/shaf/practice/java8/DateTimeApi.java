package com.shaf.practice.java8;

import java.time.*;

/*
* Before Java 8
* Date has 2 packages in Java (sql, util)
* Not a thread safe (conflict one with others)
*
* Java 8
* We have special package for all the operations
* java.time.LocalDate
*
* */
public class DateTimeApi {

    public static void main(String args[]) {
        LocalDate d = LocalDate.of(1994, Month.SEPTEMBER,23);
        System.out.println(d);

        LocalTime t = LocalTime.of(12,35,10,999);
        System.out.println(t);

        Instant i = Instant.now();
        System.out.println(i);

        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        t = LocalTime.now(ZoneId.of("GMT"));
        System.out.println(t);

        LocalDate date = LocalDate.now();

        date = date.plusMonths(1).minusWeeks(3);

        System.out.println(date);
    }
}
