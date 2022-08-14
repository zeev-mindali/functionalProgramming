package com.zeevmindali.examples;

import com.zeevmindali.beans.Car;
import com.zeevmindali.beans.Person;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedCollection {
    public static void main(String[] args) throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .toList();

        //sorted.forEach(System.out::println);

        List<String> sortedRev = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList();

        //sortedRev.forEach(System.out::println);
        Comparator<Person> comparing = Comparator
                .comparing(Person::getAge)
                .reversed()
                .thenComparing(Person::getFirstName);

        List<Person> sortedTwice = people.stream()
                .sorted(comparing)
                .toList();

        //sortedTwice.forEach(System.out::println);

        List<Car> cars = MockData.getCars();
        List<Car> topTen = cars.stream()
                .filter(car->car.getColor().equalsIgnoreCase("bLUe"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .toList();

        topTen.forEach(System.out::println);
    }
}
