package com.zeevmindali.examples;

import com.zeevmindali.beans.Person;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class NumbersExample {
    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        IntStream.range(0,10).forEach(System.out::println);
//
//        List<Person> personList = MockData.getPeople();
//
//        IntStream.range(0,5)
//                .forEach(index-> System.out.println(personList.get(index)));

        IntStream.iterate(1,value->value*2)
                .limit(21)
                .forEach(System.out::println);


    }
}
