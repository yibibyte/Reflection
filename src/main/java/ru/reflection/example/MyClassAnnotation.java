package ru.reflection.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация для класса
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyClassAnnotation {
    String author() default "Unknown";
    String date();
    int version() default 1;
}
