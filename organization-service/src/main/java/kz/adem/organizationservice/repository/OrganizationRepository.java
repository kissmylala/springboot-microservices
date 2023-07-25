package kz.adem.organizationservice.repository;

import kz.adem.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
         Organization findOrganizationByOrganizationCode(String code);
}
