package com.pluralsight.java8.module2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DStreamReduceCollector {

    public static void main(String[] args) throws FileNotFoundException {
        List<DPerson> persons = new ArrayList<>();
        System.out.println("Populating persons from file...");
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader("src/main/resources/person.txt"));
                Stream<String> lineStream = reader.lines();
        ) {
            lineStream.map(line -> {
                        String[] s = line.split(" ");
                        DPerson p = new DPerson(s[0].trim(), Integer.parseInt(s[1]));
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("To get the younger person older than 20 ...");

        Optional<DPerson> minGt20 = persons.stream().filter(l -> l.getAge() > 20).min(Comparator.comparing(DPerson::getAge));
        System.out.println(minGt20);

        System.out.println("Grouping by age ...");
        Map<Integer, List<DPerson>> collect = persons.stream().collect(
                Collectors.groupingBy(
                        DPerson::getAge
                )
        );
        //collect.forEach((l1, l2) -> System.out.println(l2));

        System.out.println("groupByAge: " + collect);

        Map<Integer, Set<String>> collect1 = persons.stream().collect(
                Collectors.groupingBy(
                        DPerson::getAge,
                        Collectors.mapping(
                                DPerson::getName,
                                Collectors.toCollection(TreeSet::new)
                        )
                )
        );

        System.out.println("groupByAgeRefactored: " + collect1);

        Map<Integer, String> collect2 = persons.stream().collect(
                Collectors.groupingBy(
                        DPerson::getAge,
                        Collectors.mapping(
                                DPerson::getName,
                                Collectors.joining(",")
                        )
                )
        );
        System.out.println("groupByAgeRefactoredMore :" + collect2);
    }
}
