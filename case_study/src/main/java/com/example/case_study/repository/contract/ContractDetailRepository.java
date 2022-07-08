package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ContractDetailRepository extends PagingAndSortingRepository<ContractDetail, Integer> {

    @Query(value = "select c from ContractDetail c where c.status = 0")
    Page<ContractDetail> findAll(Pageable pageable);

    @Query(value = "select c from ContractDetail c where c.status = 0")
    List<ContractDetail> findAll();

    @Query(value = "select * from ContractDetail where contract_id = :contract", nativeQuery =true)
    ContractDetail findByContract(@Param("contract") int id);
}
