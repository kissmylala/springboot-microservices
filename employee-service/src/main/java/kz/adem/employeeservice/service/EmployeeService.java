package kz.adem.employeeservice.service;

import kz.adem.employeeservice.dto.APIResponseDto;
import kz.adem.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
