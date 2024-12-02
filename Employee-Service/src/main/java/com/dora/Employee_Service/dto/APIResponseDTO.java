package com.dora.Employee_Service.dto;

public class APIResponseDTO {

    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
    public APIResponseDTO(){
        System.out.println("APIresponseDTO constructor got created");
    }

    public APIResponseDTO(DepartmentDto departmentDto, EmployeeDto employeeDto) {
        this.departmentDto = departmentDto;
        this.employeeDto = employeeDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }
}
