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
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
@Autowired
    public WebClient webClient;


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
//        ResponseEntity<DepartmentDto> responseEntity= restTemplate
//                .getForEntity("http://localhost:8080/api/departments/IT001"
//                        +employeeDto.getDepartmentCode(),
//                 DepartmentDto.class);

        System.out.println(webClient);
        DepartmentDto departmentDto=   webClient.get()
                .uri("http://localhost:8080/api/departments/"+employeeDto.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class).block();




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


//package com.dora.Employee_Service.service;
//
//import com.dora.Employee_Service.dto.APIResponseDTO;
//import com.dora.Employee_Service.dto.DepartmentDto;
//import com.dora.Employee_Service.dto.EmployeeDto;
//import com.dora.Employee_Service.entity.Employee;
//import com.dora.Employee_Service.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImplementation implements EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//    private final WebClient webClient;
//
//    @Autowired
//    public EmployeeServiceImplementation(EmployeeRepository employeeRepository, WebClient.Builder webClientBuilder) {
//        this.employeeRepository = employeeRepository;
//        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/departments/IT001").build();
//    }
//
//    @Override
//    public EmployeeDto saveEmployeeDetails(EmployeeDto employeeDto) {
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail(),
//                employeeDto.getDepartmentCode()
//        );
//
//        Employee savedEmployee = employeeRepository.save(employee);
//
//        return new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail(),
//                savedEmployee.getDepartmentCode()
//        );
//    }
//
//    @Override
//    public APIResponseDTO getEmployeeDetails(Long employeeId) {
//        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
//        if (employeeOptional.isEmpty()) {
//            throw new RuntimeException("Employee not found with ID: " + employeeId);
//        }
//
//        Employee employee = employeeOptional.get();
//
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
//
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/IT001" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//
//        APIResponseDTO apiResponseDTO = new APIResponseDTO();
//        apiResponseDTO.setEmployeeDto(employeeDto);
//        apiResponseDTO.setDepartmentDto(departmentDto);
//
//        return apiResponseDTO;
//    }
//}
