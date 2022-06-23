package com.example.form_register.repository;

import com.example.form_register.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface FormRegisterRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from `user` where status = 0 ", nativeQuery = true)
    Page<User> findAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into user (first_name,last_name,phone_number,age,email) " +
            "values (:firstName, :lastName, :phoneNumber,:age, :email)", nativeQuery = true)
    void create(@Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("phoneNumber") String phoneNumber,
                @Param("age") int age,
                @Param("email") String email);
}
