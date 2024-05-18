package com.javaconcepts.employee.with.atleast.one.pune.address;

import lombok.Builder;
import lombok.Data;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeWithAtleastOnePuneAddress {

    public static void main(String[] args) {
        List<Employee> employees =
                List.of(
                        Employee.builder().name("Rahul").addresses(List.of(Address.builder().pinCode("440013").build(),Address.builder().pinCode("400012").build())).build(),
                        Employee.builder().name("Shishir").addresses(List.of(Address.builder().pinCode("440013").build(),Address.builder().pinCode("500019").build())).build()
                        );

        Map<String, List<Employee>> collect = employees.stream().flatMap(e -> e.getAddresses().stream().filter(a -> a.getPinCode().equalsIgnoreCase("400012"))
                        .map(a -> new AbstractMap.SimpleEntry<>(a.getPinCode(), e)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        System.out.println(collect);
    }
}

@Data
@Builder
class Employee {
    private String name;
    private List<Address> addresses;
}

@Data
@Builder
class Address {
    private String pinCode;
}