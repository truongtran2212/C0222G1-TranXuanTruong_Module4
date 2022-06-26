package com.example.case_study.repository.employee;

import com.example.case_study.model.employee.Division;
import com.example.case_study.model.employee.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PositionRepository extends PagingAndSortingRepository<Position, Integer> {

    @Query(value = "select * from `position`", nativeQuery = true)
    List<Position> findAll();

}
