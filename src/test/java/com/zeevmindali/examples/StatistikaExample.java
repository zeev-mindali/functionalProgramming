package com.zeevmindali.examples;

import com.zeevmindali.beans.Car;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.List;

public class StatistikaExample {
    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("zeev","amital"),
            List.of("Refael","Tzachi"),
            List.of("Edi","Adi")
            );

    public static void main(String[] args) throws IOException {
        List<Car> cars = MockData.getCars();
        double min = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println("minimum price: "+min);

        double max = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println("highest price: "+max);


        double avg = cars.stream()
                .filter(item->item.getMake().equalsIgnoreCase("ford"))
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println("average cost:"+avg);

        double total = cars.stream()
                .filter(item->item.getMake().equalsIgnoreCase("ford"))
                .mapToDouble(Car::getPrice)
                .sum();

        System.out.println("Total sum :"+total);

        List<String> allFriends = arrayListOfNames.stream()
                .flatMap(List::stream)
                .toList();

        allFriends.forEach(System.out::println);

        System.out.println(arrayListOfNames);
        System.out.println(allFriends);
    }
}
