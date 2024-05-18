package com.database.understandingjpa.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String fullName;
    private EmployeeDTO manager;
    private List<EmployeeDTO> employees;
}
