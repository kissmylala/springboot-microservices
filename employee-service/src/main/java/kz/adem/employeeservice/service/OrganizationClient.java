package kz.adem.employeeservice.service;

import kz.adem.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationClient {
    @GetMapping("api/organizations/{code}")
    public OrganizationDto getOrganization(@PathVariable("code") String code);


}
