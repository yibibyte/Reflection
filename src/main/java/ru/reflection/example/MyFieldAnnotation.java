package ru.reflection.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация для полей
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyFieldAnnotation {
    String value();
}