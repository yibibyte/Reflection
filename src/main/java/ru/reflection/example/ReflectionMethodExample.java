package ru.reflection.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethodExample {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.example.MyClass");
            Method method = clazz.getMethod("myMethod", String.class);

            Object instance = clazz.getDeclaredConstructor().newInstance();
            Object result = method.invoke(instance, "Hello, Reflection!");

            System.out.println("Result: " + result);
        } catch (ClassNotFoundException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}