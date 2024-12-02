package com.dora.Department_Service.service;

import com.dora.Department_Service.dto.DepartmentDto;
import com.dora.Department_Service.entity.Department;
import com.dora.Department_Service.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImplementation implements  DepartmentService{
    DepartmentServiceImplementation(){
        System.out.println("Default constructor is defined in Sercie Impementation class...");
    }


    @Autowired
    public DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Here converting department dto to the department JPA Entity.
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDepartment=departmentRepository.save(department);

        DepartmentDto departmentDto1=new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department departmentCodee=departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto1=new DepartmentDto(
                departmentCodee.getId(),
                departmentCodee.getDepartmentName(),
                departmentCodee.getDepartmentDescription(),
                departmentCodee.getDepartmentCode()
        );
        return departmentDto1;
    }
}
