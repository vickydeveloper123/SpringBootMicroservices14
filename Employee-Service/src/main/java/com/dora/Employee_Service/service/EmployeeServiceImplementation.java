package com.dora.Employee_Service.service;

import com.dora.Employee_Service.dto.APIResponseDTO;
import com.dora.Employee_Service.dto.DepartmentDto;
import com.dora.Employee_Service.dto.EmployeeDto;
import com.dora.Employee_Service.entity.Employee;
import com.dora.Employee_Service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public RestTemplate restTemplate;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    EmployeeServiceImplementation(){
        System.out.println("Employee Service Implementation got sucessfully created....");
    }

    @Override
    public EmployeeDto saveEmployeeDetails(EmployeeDto employeeDto) {

        Employee employeeDtoo=new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode());

        Employee employee=employeeRepository.save(employeeDtoo);
        EmployeeDto employeeDto1=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode());
        return  employeeDto1;


    }

    @Override
    public APIResponseDTO getEmployeeDetails(Long employeeId) {
         Employee employeeDto= employeeRepository.findById(employeeId).get();
        ResponseEntity<DepartmentDto> responseEntity= restTemplate
                .getForEntity("http://localhost:8080/api/departments/IT001"
                        +employeeDto.getDepartmentCode(),
                 DepartmentDto.class);

        DepartmentDto departmentDto=responseEntity.getBody();

        System.out.println(departmentDto);

         EmployeeDto employeeDto1=new EmployeeDto(
                 employeeDto.getId(),
                 employeeDto.getFirstName(),
                 employeeDto.getLastName(),
                 employeeDto.getEmail(),
                 employeeDto.getDepartmentCode()
         );


        APIResponseDTO apiResponseDTO=new APIResponseDTO();
        apiResponseDTO.setEmployeeDto(employeeDto1);
        apiResponseDTO.setDepartmentDto(departmentDto);

         return  apiResponseDTO;
    }

}
