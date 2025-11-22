package com.company.Serializable;

import java.io.*;

public class Library {

    public static void writing(Person person){
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path,"Person.txt");
            System.out.println("Writing to: " + file.getAbsolutePath());

            //change the directory of the file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(person);
            objectOutputStream.close();

            System.out.println("Person serialized and written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Person reading(){
        try{
            FileInputStream fileInputStream = new FileInputStream("Person.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Person) objectInputStream.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        Person person = new Person("John", 25, "Male");
        System.out.println(person);

        writing(person);

        Person person2 = reading();
        System.out.println(person2);





    }
}