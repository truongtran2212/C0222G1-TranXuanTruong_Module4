package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.AttachService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AttachServiceRepository extends PagingAndSortingRepository<AttachService, Integer> {

    @Query(value = "select a from AttachService a ")
    List<AttachService> findAll();
}
