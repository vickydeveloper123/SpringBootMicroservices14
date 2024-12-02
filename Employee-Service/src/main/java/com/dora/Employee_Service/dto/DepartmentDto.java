package com.dora.Employee_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class DepartmentDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public DepartmentDto(Long id, String departmentName, String departmentDescription,String departmentCode) {
        this.departmentCode = departmentCode;
        this.departmentDescription = departmentDescription;
        this.departmentName = departmentName;
        this.id = id;
    }

    DepartmentDto(){
        System.out.println("Department DTO constructor has been created....");
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "departmentCode='" + departmentCode + '\'' +
                ", id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                '}';
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
