package com.zeevmindali.examples;

import com.zeevmindali.beans.Car;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarGrouping {
    public static void main(String[] args) throws IOException {
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

      map.forEach((carType,cars)->{
          System.out.println("------------------");
          System.out.println("Car type: "+carType);
          System.out.println("------------------");
          cars.forEach(System.out::println);
      });

    }
}
