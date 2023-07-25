package kz.adem.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.adem.departmentservice.dto.DepartmentDto;
import kz.adem.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/departments")
@Tag(
        name = "Department service - controller",
        description = "CRUD operations for department-service"
)
public class DepartmentController {
    private final DepartmentService service;

    //Build save department REST API
    @Operation(
            summary = "Save department REST API",
            description = "Save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 - CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = service.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get department REST API",
            description = "Get department by department-code from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 - OK"
    )
    //Build get department REST API
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = service.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
