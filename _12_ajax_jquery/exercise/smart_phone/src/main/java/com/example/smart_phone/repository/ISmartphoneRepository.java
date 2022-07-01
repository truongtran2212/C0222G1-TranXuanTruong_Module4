package com.example.smart_phone.repository;

import com.example.smart_phone.model.Smartphone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends PagingAndSortingRepository<Smartphone, Long> {


}
