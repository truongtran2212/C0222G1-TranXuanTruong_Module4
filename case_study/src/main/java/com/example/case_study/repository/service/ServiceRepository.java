package com.example.case_study.repository.service;

import com.example.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface ServiceRepository extends PagingAndSortingRepository<Service,Integer> {

    @Query(value = "SELECT s from Service as s where s.status = 0")
    Page<Service> findAll (Pageable pageable);
}