package com.example.case_study.service.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {

    Page<ContractDetail> findAll(Pageable pageable);
}
