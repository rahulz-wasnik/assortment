package com.scheduler.concurrency.service;

import com.scheduler.concurrency.entity.EmployeeEntity;
import com.scheduler.concurrency.entity.OldEmployeeRecordsEntity;
import com.scheduler.concurrency.repository.EmployeeRepository;
import com.scheduler.concurrency.repository.OldEmployeeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataLoadAndCopyService {

    @Autowired
    private OldEmployeeRecordRepository oldEmployeeRecordRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void loadAndCopyEmployeeData() {
        List<OldEmployeeRecordsEntity> oldEmployeeRecords = oldEmployeeRecordRepository.findAll();
        Set<String> savedEmployeesByFirstNames = new HashSet<>(employeeRepository.findAll().stream().map(EmployeeEntity::getEmployeeFirstName).toList());
        List<EmployeeEntity> employees = oldEmployeeRecords.stream().filter(e -> !savedEmployeesByFirstNames.contains(e.getEmployeeFirstName())).map(this::mapToEmployeeEntity).toList();

        if (!CollectionUtils.isEmpty(employees)) {
            employeeRepository.saveAll(employees);
        }
    }

    private EmployeeEntity mapToEmployeeEntity(OldEmployeeRecordsEntity old) {
        return EmployeeEntity.builder()
                .employeeFirstName(old.getEmployeeFirstName())
                .employeeLastName(old.getEmployeeLastName())
                .city(old.getCity())
                .zipCode(old.getZipCode())
                .build();
    }
}
