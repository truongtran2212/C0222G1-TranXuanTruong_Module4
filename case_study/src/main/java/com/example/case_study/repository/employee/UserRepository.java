package com.example.case_study.repository.employee;


import com.example.case_study.model.employee.UserApp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends PagingAndSortingRepository<UserApp, String> {
        @Modifying
        @Query(value = "insert into user (username, password) values (:userName, :password)", nativeQuery = true)
        void create (@Param("userName") String userName, @Param("password") String password);

        @Query(value = "select * from `user` ", nativeQuery = true)
        List<UserApp> findAll();

        UserApp findByUserName (String username);
}
