package com.example.case_study.service.service.impl;

import com.example.case_study.repository.service.ServiceRepository;
import com.example.case_study.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<com.example.case_study.model.service.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void create(com.example.case_study.model.service.Service service) {
        serviceRepository.save(service);
    }
}
