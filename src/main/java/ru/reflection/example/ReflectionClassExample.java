package ru.reflection.example;

public class ReflectionClassExample {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.example.MyClass");
            System.out.println("Class Name: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
