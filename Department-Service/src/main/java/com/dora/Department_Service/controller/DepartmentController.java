package com.dora.Department_Service.controller;
import com.dora.Department_Service.dto.DepartmentDto;
import com.dora.Department_Service.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@NoArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartmentt(@RequestBody DepartmentDto departmentDtoa){
        DepartmentDto savedDepartmentDto1=departmentService.saveDepartment(departmentDtoa);
        return new ResponseEntity<>(savedDepartmentDto1, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentEmployeeIdByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDto deparstmentCode=departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(deparstmentCode,HttpStatus.OK);
    }
}
