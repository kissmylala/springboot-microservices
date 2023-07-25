package kz.adem.organizationservice.service.impl;

import kz.adem.organizationservice.dto.OrganizationDto;
import kz.adem.organizationservice.entity.Organization;
import kz.adem.organizationservice.mapper.OrganizationMapper;
import kz.adem.organizationservice.repository.OrganizationRepository;
import kz.adem.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.MAPPER.mapToOrganization(organizationDto);
        Organization savedOrganization =  organizationRepository.save(organization);
        return OrganizationMapper.MAPPER.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization organization = organizationRepository.findOrganizationByOrganizationCode(code);
        return OrganizationMapper.MAPPER.mapToOrganizationDto(organization);
    }
}
