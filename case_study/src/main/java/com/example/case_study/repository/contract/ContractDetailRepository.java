package com.example.case_study.repository.contract;


import com.example.case_study.model.contract.AttachService;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface ContractDetailRepository extends PagingAndSortingRepository<ContractDetail, Integer> {

    @Query(value = "select c from ContractDetail c where c.status = 0")
    Page<ContractDetail> findAll(Pageable pageable);
}
