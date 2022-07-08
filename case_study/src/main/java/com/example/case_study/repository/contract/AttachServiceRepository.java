package com.example.case_study.repository.contract;

import com.example.case_study.model.contract.AttachService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AttachServiceRepository extends PagingAndSortingRepository<AttachService, Integer> {

    @Query(value = "select a from AttachService a ")
    List<AttachService> findAll();

    @Modifying
    @Query(value = "insert into attach_service (attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)" +
            " values (:name, :cost,:unit,:status)",nativeQuery = true)
    void create (@Param("name") String name,
                 @Param("cost") double cost,
                 @Param("unit") String unit,
                 @Param("status") String status);

    @Query(value = "select attach_service_id from contract_detail where contract_id = :id", nativeQuery = true)
    List<Integer> findByAttachService(@Param("id") int id);
}
