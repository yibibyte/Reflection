package ru.reflection.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация для методов
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyMethodAnnotation {
    String description();
    boolean isDeprecated() default false;
}