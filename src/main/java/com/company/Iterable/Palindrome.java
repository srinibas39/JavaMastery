package com.company.Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Palindrome implements Iterable<String> {

    // Iterable is used to implement enhanced for loop in java
    // Iterable has another interface iterator
    // Iterator has hasNext() and next() methods

    private List<String> list;

    public Palindrome() {
        list = new ArrayList<>();
    }

    public void pushString(String string) {
        list.add(string);
    }

    public class PalindromeIterator implements Iterator<String> {

        private int index = -1;

        public boolean isPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        @Override
        public boolean hasNext() {
            int i = index + 1;
            while (i < list.size()) {
                if (isPalindrome(list.get(i))) {
                    return true;
                }
                i++;
            }
            return false;
        }

        @Override
        public String next() {
            if (hasNext()) {
                int i = index + 1;
                while (i < list.size()) {
                    if (isPalindrome(list.get(i))) {
                        index = i;
                        return list.get(index);
                    }
                    i++;
                }
            }
            return null;
        }

        @Override
        public void remove() {
            list.remove(index);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new PalindromeIterator();
    }

}
