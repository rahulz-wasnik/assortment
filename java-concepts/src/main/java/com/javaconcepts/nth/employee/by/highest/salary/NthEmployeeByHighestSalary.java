package com.javaconcepts.nth.employee.by.highest.salary;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthEmployeeByHighestSalary {

    public static void main(String[] args) {

        Map<String, Integer> employees = new HashMap<>();
        employees.put("X", 1000);
        employees.put("Y", 1000);
        employees.put("Z", 2000);

        List<Map.Entry<Integer, List<String>>> list = employees.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList()))).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).toList();


        System.out.println(list);
    }
}