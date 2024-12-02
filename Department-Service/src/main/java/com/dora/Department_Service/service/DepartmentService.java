package com.dora.Department_Service.service;

import com.dora.Department_Service.dto.DepartmentDto;


public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);
}
