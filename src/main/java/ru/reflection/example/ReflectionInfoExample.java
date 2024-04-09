package ru.reflection.example;

import java.lang.reflect.*;

public class ReflectionInfoExample {

    public static void main(String[] args) {
        // Получение информации о классе
        Class<?> clazz = String.class;

        // Имя класса
        System.out.println("Class Name: " + clazz.getName());

        // Модификаторы класса
        int modifiers = clazz.getModifiers();
        System.out.println("Modifiers: " + Modifier.toString(modifiers));

        // Поля класса
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println("  " + field.getName() + ": " + field.getType());
        }

        // Методы класса
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println("  " + method.getName() + ": " + method.getReturnType());
        }
    }
}
