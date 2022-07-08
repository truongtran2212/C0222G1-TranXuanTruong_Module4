package com.example.case_study.service.contract.impl;

import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.repository.contract.ContractDetailRepository;
import com.example.case_study.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public ContractDetail findByContract(int id) {
        return contractDetailRepository.findByContract(id);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }
}
