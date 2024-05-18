package com.javaconcepts.other;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
class Employee {
    private String gender;
}

public class FindMaleAndFemaleEmployeeCountInAnOrganization {

    public static void main(String[] args) {

        List<Employee> employees = List.of(Employee.builder().gender("M").build(),
                Employee.builder().gender("M").build(),
                Employee.builder().gender("F").build());


        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(collect);

    }
}

