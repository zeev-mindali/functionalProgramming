package com.zeevmindali.examples;

import com.zeevmindali.beans.Car;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilteringCar {
    public static void main(String[] args) throws IOException {
        List<Car> myCars = MockData.getCars();

        Predicate<Car> carPredicate = car->car.getPrice()<20_000.00;
        Predicate<Car> carYellow = car->car.getColor().equalsIgnoreCase("Yellow");

        List<Car> carLessThen20K = myCars.stream()
                .filter(carPredicate)
                .filter(carYellow)
                .limit(5)
                .toList();

       //carLessThen20K.forEach(System.out::println);
        Stream.of(2,4,6,8,9,10,13)
                .filter(num->num%2==0)
                .forEach(n-> System.out.print(n+ " "));

        System.out.println();

        Stream.of(2,4,6,8,9,10,13)
                .dropWhile(num->num%2==0)
                .forEach(n-> System.out.print(n+ " "));

        System.out.println();

        Stream.of(2,4,6,8,9,10,13)
                .takeWhile(num->num%2==0)
                .forEach(n-> System.out.print(n+ " "));

        System.out.println();
        int[] numbers = {1,2,3,4,5,6,77,8,9,10};
        int result = Arrays.stream(numbers)
                .filter(n->n==7)
                .findFirst()
                .orElse(-1);

        System.out.println(result);

        int[] numbers2 = {1,2,3,4,5,6,77,8,9,9,10};
        int result2 = Arrays.stream(numbers2)
                .filter(n->n==9)
                .findAny()
                .orElse(-1);
        System.out.println(result2);

        int[] numbers3 = {2,4,6,9};
        boolean allMatch = Arrays.stream(numbers3).allMatch(n->n%2==0);
        System.out.println("all array is even:"+allMatch);

        System.out.println();

        List<Integer> numbers4 = List.of(1,2,2,3,3,4,5,5,6,6,6,7,7,8,9,9,9,9,9);
        Set<Integer> distanct = numbers4.stream().collect(Collectors.toSet());
        System.out.println(distanct);

        System.out.println();

        List<Integer> numbers5 = List.of(1,2,2,3,3,4,5,5,6,6,6,7,7,8,9,9,9,9,9);
        List<Integer> myDist = numbers5.stream()
                .distinct()
                .toList();

        System.out.println(myDist);

    }
}
