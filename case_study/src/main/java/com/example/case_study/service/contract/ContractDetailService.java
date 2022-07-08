package com.example.case_study.service.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractDetailService {

    Page<ContractDetail> findAll(Pageable pageable);

    ContractDetail findById(int id);

    ContractDetail findByContract( int id);

    List<ContractDetail> findAll();

    ContractDetail save(ContractDetail contractDetail);
}
