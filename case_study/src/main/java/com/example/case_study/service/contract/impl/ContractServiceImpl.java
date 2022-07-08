package com.example.case_study.service.contract.impl;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.repository.contract.ContractDetailRepository;
import com.example.case_study.repository.contract.ContractRepository;
import com.example.case_study.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void create(Contract contract) {
         contractRepository.save(contract);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Double total() {
        double total;
        List<Contract> contractList = contractRepository.findAll();

        for (int i = 0; i < contractList.size() ; i++) {
            total = contractList.get(i).getService().getServiceCost();
            return total;
        }
//        for (ContractDetail item: contractDetailRepository.findAll()) {
//            total += item.getAttachService().getAttachServiceCost() * item.getQuantity();
//        }
        return null;
    }
}
