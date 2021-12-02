package com.zeevmindali.examples;


import com.zeevmindali.beans.Car;
import com.zeevmindali.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));
        map.forEach((carType, cars) -> {
            System.out.println("---------------------");
            System.out.println("car type: " + carType);
            System.out.println("---------------------");
            cars.forEach(System.out::println);
        });

    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "zeev", "amital", "tal", "tal", "zeev", "tal",
                "jacob", "gabi", "gabi"
        );

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );

        System.out.println(map);

    }

}