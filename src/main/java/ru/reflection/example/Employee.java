package ru.reflection.example;

class Employee extends Person {
    private String position;
    private double salary;

    public Employee(String name, int age, String position, double salary) {
        super(name, age);
        this.position = position;
        this.salary = salary;
    }

    @MyMethodAnnotation(description = "Gets employee's position")
    public String getPosition() {
        return position;
    }

    @MyMethodAnnotation(description = "Calculates annual salary")
    private double calculateAnnualSalary() {
        return salary * 12;
    }
}
