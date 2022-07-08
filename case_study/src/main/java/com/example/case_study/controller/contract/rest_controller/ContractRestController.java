package com.example.case_study.controller.contract.rest_controller;

import com.example.case_study.model.contract.AttachService;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;

import com.example.case_study.service.contract.AttachServiceService;
import com.example.case_study.service.contract.ContractDetailService;
import com.example.case_study.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contract-rest")
public class ContractRestController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/attach-service/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        List<AttachService> attachServiceList = new ArrayList<>();
        List<Integer> list = attachServiceService.findByAttachService(id);

        for (Integer item: list) {
            attachServiceList.add(attachServiceService.findById(item));
        }
        return new ResponseEntity<>(attachServiceList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdContract(@PathVariable int id){
        Contract contract = contractService.findById(id);

        if(contract == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PostMapping("/create-contract-detail")
    public ResponseEntity<?> createContractDetail(@RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestBody ContractDetail contractDetail) {

        // Phải tạo User trc nếu kh muốn bị lỗi

        contractDetailService.save(contractDetail);
        List<Contract> contractList = contractService.findAll(PageRequest.of(page, 5)).getContent();
        return new ResponseEntity<>(contractList, HttpStatus.CREATED);
    }
}
