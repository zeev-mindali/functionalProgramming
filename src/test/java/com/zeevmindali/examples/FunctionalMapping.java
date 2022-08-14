package com.zeevmindali.examples;

import com.zeevmindali.beans.Person;
import com.zeevmindali.beans.PersonDTO;
import com.zeevmindali.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class FunctionalMapping {
    public static void main(String[] args) throws IOException {
        List<Person> personList = MockData.getPeople();

//        Function<Person, PersonDTO> personToPersonDTO = person->
//                new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//

        List<PersonDTO> dtos = personList.stream()
                .filter(person->person.getAge()>20)
                .map(PersonDTO::map)
                .toList();

        dtos.forEach(System.out::println);
    }
}
