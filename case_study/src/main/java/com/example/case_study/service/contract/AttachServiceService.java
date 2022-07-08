package com.example.case_study.service.contract;

import com.example.case_study.model.contract.AttachService;
import com.example.case_study.model.contract.Contract;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttachServiceService {

    List<AttachService> findAll();

    void create (AttachService attachService);

    List<Integer> findByAttachService(int id);

    AttachService findById (int id);

}
