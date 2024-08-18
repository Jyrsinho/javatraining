package EmployeeSorter;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    // Comparator to compare Employees by age
    public static final Comparator<Employee> BY_AGE = Comparator.comparingInt(Employee::getAge);

    // Comparator to compare Employees by salary
    public static final Comparator<Employee> BY_SALARY = Comparator.comparingDouble(Employee::getSalary);
}






