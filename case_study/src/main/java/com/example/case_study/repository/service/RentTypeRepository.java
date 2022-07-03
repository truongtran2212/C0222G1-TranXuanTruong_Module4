package com.example.case_study.repository.service;

import com.example.case_study.model.service.RentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RentTypeRepository extends PagingAndSortingRepository<RentType,Integer> {

    @Query(value = "select r from RentType r")
    List<RentType> findAll ();
}
