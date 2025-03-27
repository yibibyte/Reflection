package ru.reflection.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionMethodExample {
    public static void main(String[] args) {
        try {
            List<Class<?>> classes = new ArrayList<>();

            MyClass myClass = new MyClass();
            Class<?> clazz = Class.forName("ru.reflection.example.MyClass");
            Class<?> clazz2 = MyClass.class;
            Class<?> clazz3 = new MyClass().getClass().getSuperclass();
            Class<?> clazz4 = MyClass.class.getSuperclass();
            Class<?> clazz5 = myClass.getClass();
            Class<?> clazz6 = Class.forName("ru.reflection.example.MyClass");
            Class<?> clazz7 = myClass.getClass().asSubclass(MyClass.class);

            classes.add(clazz);
            classes.add(clazz2);
            classes.add(clazz3);
            classes.add(clazz4);
            classes.add(clazz5);
            classes.add(clazz6);

            for (Class<?> class1 : classes) {
                if (class1 != null) {
                    System.out.println("Вывод класса: " + class1.getName());
                }
            Method method = clazz.getMethod("myMethod");

            Object instance = clazz.getDeclaredConstructor().newInstance();
            Object result = method.invoke(instance);

            System.out.println("Вывод метода method.invoke(instance): " + result);
        }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}