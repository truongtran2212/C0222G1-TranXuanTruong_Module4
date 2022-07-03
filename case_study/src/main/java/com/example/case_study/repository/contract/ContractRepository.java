package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;


@Transactional
public interface ContractRepository extends PagingAndSortingRepository<Contract, Integer> {

    @Query(value = "select c from Contract c where c.status = 0")
    Page<Contract> findAll(Pageable pageable);
}
