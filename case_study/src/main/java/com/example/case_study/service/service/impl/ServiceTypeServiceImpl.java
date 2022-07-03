package com.example.case_study.service.service.impl;

import com.example.case_study.model.service.ServiceType;
import com.example.case_study.repository.service.ServiceTypeRepository;
import com.example.case_study.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
