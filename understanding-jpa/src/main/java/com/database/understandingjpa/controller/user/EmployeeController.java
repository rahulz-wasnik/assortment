package com.database.understandingjpa.controller.user;

import com.database.understandingjpa.dto.user.EmployeeDTO;
import com.database.understandingjpa.entity.user.EmployeeEntity;
import com.database.understandingjpa.repository.user.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<EmployeeEntity> save(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity savedManager = employeeRepository.save(employeeEntity.getManager());
        employeeEntity.getEmployees().forEach(e -> {
            e.setManager(savedManager);
        });
        List<EmployeeEntity> employees = employeeRepository.saveAll(employeeEntity.getEmployees());
        EmployeeEntity employee = new EmployeeEntity();
        employee.setManager(savedManager);
        employee.setEmployees(employees);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
        EmployeeEntity savedEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        EmployeeDTO manager = mapToDTO(savedEmployee);


        List<EmployeeDTO> employees = savedEmployee.getEmployees().stream().map(this::mapToDTO).toList();
        manager.setEmployees(employees);

        return ResponseEntity.ok(manager);
    }

    private EmployeeDTO mapToDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setFullName(employeeEntity.getFullName());
        employee.setLastName(employeeEntity.getLastName());
        return employee;
    }

}
