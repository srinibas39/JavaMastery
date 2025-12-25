package com.company.Iterable;

import java.util.Iterator;

public class Library {
    public static void main(String[] args) {

        Palindrome p = new Palindrome();
        p.pushString("madam");
        p.pushString("hello");
        p.pushString("racecar");
        p.pushString("java");

        for (String s : p) {
            System.out.println(s);
        }

        Iterator<String> pIt = p.iterator();
        while (pIt.hasNext()) {
            System.out.println(pIt.next());
        }

    }
}
