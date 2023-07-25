package kz.adem.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.adem.organizationservice.dto.OrganizationDto;
import kz.adem.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@RequiredArgsConstructor
@Tag(
        name = "Organization service - controller",
        description = "CRUD operations for organization-service"
)
public class OrganizationController {
    private final OrganizationService organizationService;
    @Operation(
            summary = "Save organization REST API",
            description = "Save organization object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 - CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto savedOrganizationDto =  organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get organization REST API",
            description = "Get organization by organization code from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 - OK"
    )
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String code){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
        return new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }
}
