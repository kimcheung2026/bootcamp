package com.bootcamp.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bootcamp.demo.DemoStream.Person.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class DemoStream {
  public static void main(String[] args) {
    // Loop
    // 1. for-loop
    List<String> names = new ArrayList<>(List.of("John", "Peter"));
    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.get(i));
    }
    // 2. for-each loop
    for (String name : names) {
      System.out.println(names);
    }
    // 3. while loop
    int idx = 0;
    while (idx < names.size()) {
      System.out.println(names.get(idx));
      idx++;

    }
    // ! 4 stream (Java 8)
    names.stream() // Stream <String>
        .forEach(name -> System.out.println(name));

    // ! 4.stream for loop + if
    // filter -> if
    names.stream() //
        .filter(name -> name.length() >= 5) //
        .forEach(name -> System.out.println(name)); // send sms

    // ! 4. stream collect
    List<String> newNames = names.stream() //
        .filter(name -> name.startsWith("P") && name.length() >= 5) //
        .collect(Collectors.toList());
    System.out.println(newNames); // [Peter]

    // ! 4. stream map
    List<Cat> cats = names.stream() //
        .filter(name -> name.startsWith("J")) // Stream<String>
        .map(name -> new Cat(name)) // Stream<Cat>
        .collect(Collectors.toList()); // List<Cat>
    System.out.println(cats);

    List<Cat> newCats = new ArrayList<>();
    for (String name : names) {
      if (name.startsWith("J")) {
        newCats.add(new Cat(name));
      }
    }

    // dogs = 4 Dog Objects
    List<Dog> dogs = Arrays.asList(
        new Dog("Buddy", 3),
        new Dog("Max", 5),
        new Dog("Charlie", 2),
        new Dog("Daisy", 4));
    List<Integer> dogAges = dogs.stream()
        .filter(dog -> dog.getAge() > 2) // 一樣可以跑 Stream 過濾
        .map(dog -> dog.getAge()) // 先把 Dog 變成 Integer (年齡)
        .collect(Collectors.toList()); // 最後把這些Object全部放進籃子（List）裡。

    System.out.println(dogAges);

    // sorting
    // descending order of age
    List<Dog> sortedDogs = dogs.stream() //
        .sorted((d1, d2) -> d1.getAge() > d2.getAge() ? -1 : 1) //
        .collect(Collectors.toList());
    System.out.println(sortedDogs);
    // [Dog(age=20, name=Tommy), Dog(age=20, name=Tommy), Dog(age=10, name=Steve),
    // Dog(age=8,
    // name=Mary), Dog(age=4, name=Sally)]

    List<Dog> sortedDogAge = dogs.stream() //
        // .map(dog -> dog.getAge())
        .sorted() // ! compareTo
        .collect(Collectors.toList());
    System.out.println(sortedDogAge);
    // [Dog(age=4, name=Sally), Dog(age=8, name=Mary), Dog(age=10, name=Steve),
    // Dog(age=20, name=Tommy),
    // Dog(age=20, name=Tommy)]

    // distinct (unique)
    // distinct dogs
    List<String> uniqueDogNames = dogs.stream() //
        .filter(dog -> dog.getAge() >= 10) //
        .distinct() //
        .sorted() //
        .map(dog -> dog.getName()) //
        .collect(Collectors.toList());

    System.out.println(uniqueDogNames); // [Steve, Tommy]

    // flatmap
    List<Address> addresses = new ArrayList<>(List.of(new Address("address 1"),
        new Address("address 2"), new Address("address 3")));
    Person p1 = new Person(addresses);

    List<Address> addresses2 = new ArrayList<>(
        List.of(new Address("address 4"), new Address("address 5")));
    Person p2 = new Person(addresses2);

    List<Person> persons = new ArrayList<>(List.of(p1, p2));
    List<String> allAddressLines = persons.stream() //
        .flatMap(p -> p.getAddresses().stream()) // Stream<Address>
        .map(a -> a.getLine()) // Stream<String>
        .collect(Collectors.toList());
    System.out.println(allAddressLines);
    // [address 1, address 2, address 3, address 4, address 5]

    // Stream<String>
    Stream<String> names2 = Stream.of("John", "Peter");

    Stream<String> names2AfterFiltered = names2.filter(e -> e.length() >= 5);

    List<String> finalNames = names2AfterFiltered.collect(Collectors.toList());

    System.out.println(finalNames);

    // ! List -> Stream -> List
  }

  @AllArgsConstructor
  @Getter
  @ToString
  public static class Person {
    private List<Address> addresses;

    @AllArgsConstructor
    @Getter
    @ToString
    public static class Address {
      private String line;
    }
  }
}
