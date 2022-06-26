package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.CustomerType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {

    @Query(value = "select c from CustomerType c")
    List<CustomerType> findAll();
}
