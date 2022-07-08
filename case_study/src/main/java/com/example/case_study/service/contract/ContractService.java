package com.example.case_study.service.contract;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    void create(Contract contract);

    Contract findById(int id);

    Double total();
}
