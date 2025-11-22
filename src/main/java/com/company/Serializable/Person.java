package com.company.Serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private String gender;

    //constructor
    public Person(String name , int age , String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    //toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
