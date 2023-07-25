package kz.adem.departmentservice.service.impl;

import kz.adem.departmentservice.dto.DepartmentDto;
import kz.adem.departmentservice.entity.Department;
import kz.adem.departmentservice.exception.ResourceNotFoundException;
import kz.adem.departmentservice.mapper.AutoUserMapper;
import kz.adem.departmentservice.repository.DepartmentRepository;
import kz.adem.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert departmentDto to department JPA entity
        Department department = AutoUserMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = repository.save(department);
        DepartmentDto savedDepartmentDto = AutoUserMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = repository.findDepartmentByDepartmentCode(departmentCode);
        if (department==null){
            throw new ResourceNotFoundException("Department","code",departmentCode);
        }
        DepartmentDto departmentDto = AutoUserMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
