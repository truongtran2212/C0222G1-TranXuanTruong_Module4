package com.example.case_study.repository.employee;

import com.example.case_study.model.employee.Division;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DivisionRepository extends PagingAndSortingRepository<Division, Integer> {

    @Query(value = "select * from division", nativeQuery = true)
    List<Division> findAll();
}
