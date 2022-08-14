package com.zeevmindali.examples;

import com.zeevmindali.beans.Car;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class NumberAgg {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = List.of(1,2,3,100,23,93,99);
        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(min);
        int max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);

        List<Car> myCars = MockData.getCars();
        long allCars = myCars.stream()
                .filter(car->car.getMake().equalsIgnoreCase("ford"))
                .filter(car->car.getYear()>2010)
                .count();

        System.out.println("total ford from year 2011:"+allCars);

    }
}
