package kz.adem.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import kz.adem.employeeservice.dto.APIResponseDto;
import kz.adem.employeeservice.dto.DepartmentDto;
import kz.adem.employeeservice.dto.EmployeeDto;
import kz.adem.employeeservice.dto.OrganizationDto;
import kz.adem.employeeservice.entity.Employee;
import kz.adem.employeeservice.exception.ResourceNotFoundException;
import kz.adem.employeeservice.mapper.EmployeeMapper;
import kz.adem.employeeservice.repository.EmployeeRepository;
import kz.adem.employeeservice.service.APIClient;
import kz.adem.employeeservice.service.EmployeeService;
import kz.adem.employeeservice.service.OrganizationClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository repository;
      private final APIClient apiClient;
      private final OrganizationClient organizationClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = repository.save(employee);
        EmployeeDto savedDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedDto;
    }

    @Override
    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
//    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("inside getEmployeeById method");
        Employee employee = repository.findById(employeeId).orElseThrow(()->{
            throw  new ResourceNotFoundException("Employee","ID",employeeId);
        });

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        OrganizationDto organizationDto = organizationClient.getOrganization(employee.getOrganizationCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }
    public APIResponseDto getDefaultDepartment(Long employeeId,Exception e) {
        LOGGER.info("inside getDefaultDepartment method");
        Employee employee = repository.findById(employeeId).orElseThrow(()->{
            throw  new ResourceNotFoundException("Employee","ID",employeeId);
        });
        DepartmentDto departmentDto = DepartmentDto.builder()
                .departmentCode("R&D Department")
                .departmentName("RD001")
                .departmentDescription("Research and development department")
                .build();
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
    }
