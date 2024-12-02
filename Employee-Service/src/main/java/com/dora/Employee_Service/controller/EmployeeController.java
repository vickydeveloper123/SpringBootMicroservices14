package com.dora.Employee_Service.controller;

import com.dora.Employee_Service.dto.APIResponseDTO;
import com.dora.Employee_Service.dto.EmployeeDto;
import com.dora.Employee_Service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController

@RequestMapping("api/details")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    EmployeeController(){
        System.out.println("Employee constructor got created and running sucesfully");
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> savingEmployeeDetails(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1= employeeService.saveEmployeeDetails(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public  ResponseEntity<APIResponseDTO> getAllEmployersDetails(@PathVariable("id") Long employersId){
        APIResponseDTO apiResponseDTOemployeeDto= employeeService.getEmployeeDetails(employersId);
        return new ResponseEntity<>(apiResponseDTOemployeeDto,HttpStatus.OK);
    }

}
