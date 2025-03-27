package ru.reflection.example;

import java.util.List;

@MyClassAnnotation(author = "John Doe", date = "2023-05-15", version = 2)
public class Person {
    @MyFieldAnnotation("Person's full name")
    private String name;

    @MyFieldAnnotation("Person's age in years")
    protected int age;

    public static final String SPECIES = "Homo sapiens";

    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @MyMethodAnnotation(description = "Gets person's name", isDeprecated = false)
    public String getName() {
        return name;
    }

    @MyMethodAnnotation(description = "Sets person's name")
    private void setName(String name) {
        this.name = name;
    }

    @Deprecated
    @MyMethodAnnotation(description = "Old method to print info", isDeprecated = true)
    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    @MyMethodAnnotation(description = "Processes list of integers")
    public static int processNumbers(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

