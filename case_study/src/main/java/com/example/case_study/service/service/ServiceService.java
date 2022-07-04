package com.example.case_study.service.service;

import com.example.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll (Pageable pageable);

    void create (Service service);
}
