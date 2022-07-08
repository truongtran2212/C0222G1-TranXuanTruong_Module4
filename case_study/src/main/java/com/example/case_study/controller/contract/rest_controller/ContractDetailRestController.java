package com.example.case_study.controller.contract.rest_controller;

import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.service.contract.AttachServiceService;
import com.example.case_study.service.contract.ContractDetailService;
import com.example.case_study.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractDetailRestController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private ContractService contractService;

//    @GetMapping("/attach-service/{id}")
//    public ResponseEntity<?> findById(@PathVariable int id){
//        ContractDetail contractDetail = contractDetailService.findById(id);
//        if(contractDetail == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(contractDetail, HttpStatus.OK);
//    }
}
