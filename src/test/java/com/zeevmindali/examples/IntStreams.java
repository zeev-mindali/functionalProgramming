package com.zeevmindali.examples;


import com.zeevmindali.beans.Person;
import com.zeevmindali.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("with fori");
        for (int index = 0; index <= 10; index++) {
            System.out.print(index+" ");
        }
        System.out.println();
        System.out.println("with int stream exclusive");
        IntStream.range(0, 10).forEach(System.out::print);
        System.out.println();
        System.out.println("with int stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::print);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, 5)
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0, value -> value + 1)
                .limit(11)
                .forEach(System.out::println);
    }
}
