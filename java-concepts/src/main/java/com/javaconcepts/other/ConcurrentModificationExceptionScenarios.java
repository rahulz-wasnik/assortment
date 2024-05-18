package com.javaconcepts.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcurrentModificationExceptionScenarios {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");


        for (int i = 0; i < list.size(); i++) {
            list.remove(i); //  suspicious 'List.remove()' in loop
            list.add("f"); // not throw ConcurrentModificationException
        }

        for (String emp:
              list) {
            list.remove("C"); // not throw ConcurrentModificationException
            list.add("f"); // throw ConcurrentModificationException
        }

        list.forEach(e -> {
            list.remove(e); // This will throw ConcurrentModificationException
            list.add("X"); //  This will throw ConcurrentModificationException
        });

        System.out.println(list);

        new HashMap<>();
    }
}

class EmployeeForModification {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
