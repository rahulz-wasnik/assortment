package com.scheduler.concurrency.controller;

import com.github.javafaker.Faker;
import com.scheduler.concurrency.entity.OldEmployeeRecordsEntity;
import com.scheduler.concurrency.repository.OldEmployeeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private OldEmployeeRecordRepository oldEmployeeRecordRepository;

    @GetMapping
    public List<OldEmployeeRecordsEntity> populateOldEmployeeEntityRecords() {
        Faker faker = new Faker();
        List<OldEmployeeRecordsEntity> oldEmployeeRecords = new ArrayList<>();
        for(int iterator = 0; iterator <= 10000; iterator++) {
            OldEmployeeRecordsEntity oldEmployeeRecord = OldEmployeeRecordsEntity.builder()
                    .employeeFirstName(faker.name().firstName())
                    .employeeLastName(faker.name().lastName())
                    .city(faker.address().cityName())
                    .zipCode(faker.address().zipCode())
                    .build();
            oldEmployeeRecords.add(oldEmployeeRecord);
        }

        return oldEmployeeRecordRepository.saveAll(oldEmployeeRecords);
    }
}
