package com.dora.Employee_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;

    EmployeeDto(){}

    public EmployeeDto(Long id, String firstName, String lastName, String email, String departmentCode) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.departmentCode=departmentCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //    public EmployeeDto( Long id, String firstName, String lastName,String email) {
//        this.id = id;
//        this.firstName = firstName;
//
//        this.lastName = lastName;
//        this.email = email;
//
//    }
//
//
//    public EmployeeDto( Long id, String firstName, String lastName,String email,String departmentCode) {
//        this.id = id;
//        this.firstName = firstName;
//
//        this.lastName = lastName;
//        this.email = email;
//        this.departmentCode=departmentCode;
//
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeDto{" +
//                "email='" + email + '\'' +
//                ", id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }
//
//    EmployeeDto(){
//        System.out.println("Employee DTO Default constructor is created....");
//    }
}
