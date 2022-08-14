package com.zeevmindali.examples;

import com.zeevmindali.beans.Car;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
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
        Stream.of(2,4,6,8,9,10,13).filter(num->num%2==0).forEach(n-> System.out.print(n+ " "));
    }
}
