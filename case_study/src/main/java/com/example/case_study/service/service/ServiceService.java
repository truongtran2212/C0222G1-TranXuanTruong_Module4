package com.example.case_study.service.service;

import com.example.case_study.model.service.dto.ServiceDto;
import com.example.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceService {
    Page<Service> findAll (Pageable pageable);

    void create (ServiceDto serviceDto);

    List<Service> findAll ();

    void update (ServiceDto serviceDto);

    Service findById(int id);
}
