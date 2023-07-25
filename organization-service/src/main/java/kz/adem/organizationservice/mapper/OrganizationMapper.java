package kz.adem.organizationservice.mapper;

import kz.adem.organizationservice.dto.OrganizationDto;
import kz.adem.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper MAPPER = Mappers.getMapper(OrganizationMapper.class);
    OrganizationDto mapToOrganizationDto(Organization organization);
    Organization mapToOrganization(OrganizationDto organizationDto);
}
