package ru.reflection.example;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Получение класса и информации о нем
        Class<?> personClass = Class.forName("ru.reflection.example.Person");
        System.out.println("=== Class Information ===");
        System.out.println("Class name: " + personClass.getName());
        System.out.println("Simple name: " + personClass.getSimpleName());
        System.out.println("Modifiers: " + Modifier.toString(personClass.getModifiers()));
        System.out.println("Superclass: " + personClass.getSuperclass().getName());

        // Работа с аннотациями класса
        MyClassAnnotation classAnnotation = personClass.getAnnotation(MyClassAnnotation.class);
        System.out.println("\n=== Class Annotations ===");
        System.out.println("Author: " + classAnnotation.author());
        System.out.println("Date: " + classAnnotation.date());
        System.out.println("Version: " + classAnnotation.version());

        // Работа с полями
        System.out.println("\n=== Fields ===");
        for (Field field : personClass.getDeclaredFields()) {
            System.out.println("\nField: " + field.getName());
            System.out.println("Type: " + field.getType().getName());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));

            MyFieldAnnotation fieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
            if (fieldAnnotation != null) {
                System.out.println("Annotation value: " + fieldAnnotation.value());
            }

            // Доступ к private полю
            if (field.getName().equals("name")) {
                Person person = new Person("Alice", 30);
                field.setAccessible(true);
                System.out.println("Original value: " + field.get(person));
                field.set(person, "Bob");
                System.out.println("Modified value: " + field.get(person));
            }
        }

        // Работа с методами
        System.out.println("\n=== Methods ===");
        for (Method method : personClass.getDeclaredMethods()) {
            System.out.println("\nMethod: " + method.getName());
            System.out.println("Return type: " + method.getReturnType().getName());
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println("Parameters: " + Arrays.toString(method.getParameterTypes()));

            // Аннотации метода
            MyMethodAnnotation methodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
            if (methodAnnotation != null) {
                System.out.println("Description: " + methodAnnotation.description());
                System.out.println("Deprecated: " + methodAnnotation.isDeprecated());
            }

            // Вызов метода
            if (method.getName().equals("printInfo") && method.getParameterCount() == 0) {
                Person person = new Person("Charlie", 25);
                method.invoke(person);
            }

            // Вызов private метода
            if (method.getName().equals("setName") && method.getParameterCount() == 1) {
                Person person = new Person();
                method.setAccessible(true);
                method.invoke(person, "David");
                System.out.println("After setName: " + person.getName());
            }

            // Вызов статического метода
            if (method.getName().equals("processNumbers") && Modifier.isStatic(method.getModifiers())) {
                int result = (int) method.invoke(null, List.of(1, 2, 3, 4, 5));
                System.out.println("Sum of numbers: " + result);
            }
        }

        // Работа с конструкторами
        System.out.println("\n=== Constructors ===");
        for (Constructor<?> constructor : personClass.getDeclaredConstructors()) {
            System.out.println("\nConstructor: " + constructor.getName());
            System.out.println("Parameters: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));

            // Создание экземпляра через рефлексию
            if (constructor.getParameterCount() == 2) {
                Person person = (Person) constructor.newInstance("Eve", 28);
                System.out.println("Created person: " + person.getName() + ", " + person.getAge());
            }
        }

        // Работа с наследованием
        System.out.println("\n=== Inheritance ===");
        Class<?> employeeClass = Employee.class;
        System.out.println("Employee superclass: " + employeeClass.getSuperclass().getName());

        // Получение всех методов (включая унаследованные)
        System.out.println("\nAll Employee methods:");
        for (Method method : employeeClass.getMethods()) {
            System.out.println(method.getName() + " from " + method.getDeclaringClass().getSimpleName());
        }

        // Работа с массивами через рефлексию
        System.out.println("\n=== Arrays ===");
        int[] intArray = (int[]) Array.newInstance(int.class, 5);
        System.out.println("Array length: " + Array.getLength(intArray));
        Array.set(intArray, 0, 10);
        Array.set(intArray, 1, 20);
        System.out.println("Array values: " + Arrays.toString(intArray));

        // Динамические прокси
        System.out.println("\n=== Dynamic Proxies ===");
        Greeter greeter = (Greeter) Proxy.newProxyInstance(
                Greeter.class.getClassLoader(),
                new Class<?>[] { Greeter.class },
                (proxy, method, vars) -> "Hello, " + vars[0]);

        System.out.println(greeter.greet("ru.reflection.example.World"));
    }
}

interface Greeter {
    String greet(String name);
}