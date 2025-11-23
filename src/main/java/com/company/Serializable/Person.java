package com.company.Serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String  password;

    //constructor
    public Person(String name , int age , String gender , String password){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.password = password;
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


    public final void writeObject(ObjectOutputStream objectOutputStream){
        try{
               objectOutputStream.writeObject((password+"#").getBytes());
               objectOutputStream.defaultWriteObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public final void readObject(ObjectInputStream objectInputStream){
        try{
            String password = new String((byte[])objectInputStream.readObject());
            if(password.equals(this.password+"#")){
                objectInputStream.defaultReadObject();
            }
            else{
                throw new Exception("Invalid password");
            }
        }
        catch(Exception e){}
    }



    //toString
  @Override
    public String toString() {
       return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", gender='" + gender + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
