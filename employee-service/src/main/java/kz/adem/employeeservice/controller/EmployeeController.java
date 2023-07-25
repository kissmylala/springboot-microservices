package kz.adem.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.adem.employeeservice.dto.APIResponseDto;
import kz.adem.employeeservice.dto.EmployeeDto;
import kz.adem.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
@Tag(
        name = "Employee service - controller",
        description = "CRUD operations for Employee-service"
)
public class EmployeeController {
    private final EmployeeService service;
    @Operation(
            summary = "Save employee REST API",
            description = "Save employee object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 - CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = service.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Employee REST API",
            description = "Get employee by employee id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 - OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long id){
        APIResponseDto apiResponseDto = service.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
