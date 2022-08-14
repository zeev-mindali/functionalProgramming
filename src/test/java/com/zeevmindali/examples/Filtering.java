package com.zeevmindali.examples;

import com.zeevmindali.beans.Person;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) throws IOException {
        List<Person> persons = MockData.getPeople();
//        List<Person> youngPersons = new ArrayList<>();

//        int limit = 10;
//        int counter = 0;
//        for (Person person:persons){
//            if (person.getAge()<=18){
//                youngPersons.add(person);
//                counter++;
//                if (counter==limit){
//                    break;
//                }
//            }
//        }

        int myLimit = 15;
        List<Person> youngPersons = persons.stream()
                .filter(item -> item.getAge() <= 18)
                .limit(5)
                .toList();

        youngPersons.forEach(System.out::println);
    }
}
