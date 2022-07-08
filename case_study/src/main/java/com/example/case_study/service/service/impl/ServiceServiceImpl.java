package com.example.case_study.service.service.impl;

import com.example.case_study.model.service.dto.ServiceDto;
import com.example.case_study.repository.service.ServiceRepository;
import com.example.case_study.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<com.example.case_study.model.service.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void create(ServiceDto serviceDto) {
        serviceRepository.create(   serviceDto.getServiceCode(),
                                    serviceDto.getServiceName(),
                                    serviceDto.getServiceArea(),
                                    serviceDto.getServiceCost(),
                                    serviceDto.getServiceMaxPeople(),
                                    serviceDto.getStandardRoom(),
                                    serviceDto.getDescriptionOtherConvenience(),
                                    serviceDto.getPoolArea(),
                                    serviceDto.getNumberOfFloors(),
                                    serviceDto.getRentType().getRentTypeId(),
                                    serviceDto.getServiceType().getServiceTypeId());
    }

    @Override
    public List<com.example.case_study.model.service.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void update(ServiceDto serviceDto) {
        serviceRepository.update(
                serviceDto.getServiceName(),
                serviceDto.getServiceArea(),
                serviceDto.getServiceCost(),
                serviceDto.getServiceMaxPeople(),
                serviceDto.getStandardRoom(),
                serviceDto.getDescriptionOtherConvenience(),
                serviceDto.getPoolArea(),
                serviceDto.getNumberOfFloors(),
                serviceDto.getRentType().getRentTypeId(),
                serviceDto.getServiceType().getServiceTypeId(),
                serviceDto.getServiceId());
    }

    @Override
    public com.example.case_study.model.service.Service findById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }


}
