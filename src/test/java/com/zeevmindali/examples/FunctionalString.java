package com.zeevmindali.examples;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalString {

    public static void main(String[] args) {
        List<String> names = List.of("zeev","Amital","nipo","hilda 666","Sasson","Michal");
        StringBuilder join = new StringBuilder();

        for (String name:names){
            join.append(name.substring(0,1).toUpperCase())
                    .append(name.substring(1))
                    .append(", ");
        }
        System.out.println(join.substring(0,join.length()-2));

        String lazyJoin = names.stream()
                .map(name->name.substring(0,1).toUpperCase()+name.substring(1))
                .collect(Collectors.joining(" / "));

        System.out.println(lazyJoin);
    }
}
