package com.company.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Interface {

    // Interface is a contract

    // Functional Interface --> has only one abstract method
    // Runnable, Callable, Comparator, Function , Predicate

    // Streams are used to process collections of objects

    public static void main(String[] args) {
        Student s1 = new Student("Srinibas", 20, 3);
        Student s2 = new Student("Rahul", 21, 4);
        Student s3 = new Student("Ravi", 22, 5);
        Student s4 = new Student("Raj", 23, 6);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        Predicate<Student> filterByAge = new Predicate<Student>() {
            @Override
            public boolean test(Student s) {
                return s.getAge() > 21;
            }
        };

        List<Student> filteredStudents = students.stream().filter(filterByAge).collect(Collectors.toList());
        System.out.println(filteredStudents);

        // In Java, a parallelStream 🧬 is a tool that allows you to process
        // collections of data across multiple CPU cores simultaneously.
        // While a standard stream processes elements one by one in a single sequence
        // (linearly), a parallelStream splits the data into smaller
        // chunks and executes them in parallel using the ForkJoinPool.

        students.parallelStream().forEach(s -> System.out.println(s.getName()));

    }
}
