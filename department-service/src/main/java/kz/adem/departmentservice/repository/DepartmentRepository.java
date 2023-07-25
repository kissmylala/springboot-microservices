package kz.adem.departmentservice.repository;

import kz.adem.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentCode(String departmentCode);
}
