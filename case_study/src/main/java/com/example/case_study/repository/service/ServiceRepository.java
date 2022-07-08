package com.example.case_study.repository.service;

import com.example.case_study.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ServiceRepository extends PagingAndSortingRepository<Service, Integer> {

    @Query(value = "SELECT s from Service as s where s.status = 0")
    Page<Service> findAll(Pageable pageable);

    @Query(value = "SELECT s from Service as s where s.status = 0")
    List<Service> findAll();

    @Modifying
    @Query(value = "insert into service (service_code,service_name,service_area,service_cost,service_max_people," +
            "standard_room,description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id) " +
            "values (:serviceCode,:serviceName,:serviceArea,:serviceCost,:serviceMaxPeople,:standardRoom,:descriptionOtherConvenience," +
            ":poolArea,:numberOfFloors,:rentType,:serviceType)", nativeQuery = true)
    void create(@Param("serviceCode") String serviceCode,
                @Param("serviceName") String serviceName,
                @Param("serviceArea") Integer serviceArea,
                @Param("serviceCost") Double serviceCost,
                @Param("serviceMaxPeople") Integer serviceMaxPeople,
                @Param("standardRoom") String standardRoom,
                @Param("descriptionOtherConvenience") String descriptionOtherConvenience,
                @Param("poolArea") Double poolArea,
                @Param("numberOfFloors") Integer numberOfFloors,
                @Param("rentType") Integer rentType,
                @Param("serviceType") Integer serviceType);

    @Modifying
    @Query(value = "update service set (service_name = :serviceName,service_area =:serviceArea ,service_cost = :serviceCost," +
            "service_max_people = :serviceMaxPeople,standard_room = :standardRoom,description_other_convenience = :descriptionOtherConvenience," +
            " pool_area =:poolArea , number_of_floors = :numberOfFloors, rent_type_id = :rentType, service_type_id = :serviceType)" +
            " where service_id = :id", nativeQuery = true)
    void update (
                 @Param("serviceName") String serviceName,
                 @Param("serviceArea") Integer serviceArea,
                 @Param("serviceCost") Double serviceCost,
                 @Param("serviceMaxPeople") Integer serviceMaxPeople,
                 @Param("standardRoom") String standardRoom,
                 @Param("descriptionOtherConvenience") String descriptionOtherConvenience,
                 @Param("poolArea") Double poolArea,
                 @Param("numberOfFloors") Integer numberOfFloors,
                 @Param("rentType") int rentType,
                 @Param("serviceType") int serviceType,
                 @Param("id") int serviceId);
}