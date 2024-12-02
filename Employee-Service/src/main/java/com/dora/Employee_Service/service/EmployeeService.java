package com.dora.Employee_Service.service;

import com.dora.Employee_Service.dto.APIResponseDTO;
import com.dora.Employee_Service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployeeDetails(EmployeeDto employeeDto);
    APIResponseDTO getEmployeeDetails(Long employeeId);
}
