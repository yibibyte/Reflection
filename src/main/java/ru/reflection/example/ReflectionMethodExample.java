package ru.reflection.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethodExample {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("ru.reflection.example.MyClass");
            Method method = clazz.getMethod("myMethod");

            Object instance = clazz.getDeclaredConstructor().newInstance();
            Object result = method.invoke(instance);

            System.out.println("Вывод метода method.invoke(instance): " + result);
        } catch (ClassNotFoundException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}