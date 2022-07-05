package com.example.case_study.repository.customer;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    @Query(value = "select c from Customer c where c.status = 0 and c.customerName like %:name%")
    Page<Customer> findAll(Pageable pageable, @Param("name") String name);

    @Modifying
    @Query(value = "insert into customer (customer_code,customer_name,customer_birthday,customer_gender,customer_id_card," +
            "customer_phone,customer_email,customer_address,customer_type_id) values" +
            " (:customerCode,:customerName,:customerBirthday,:customerGender,:customerIdCard," +
            ":customerPhone,:customerEmail,:customerAddress,:customerType)", nativeQuery = true)

    // Dùng câu truy vấn động bị lỗi
    CustomerDto create(@Param("customerCode") String customerCode,
                @Param("customerName") String customerName,
                @Param("customerBirthday") String customerBirthday,
                @Param("customerGender") int customerGender,
                @Param("customerIdCard") String customerIdCard,
                @Param("customerPhone") String customerPhone,
                @Param("customerEmail") String customerEmail,
                @Param("customerAddress") String customerAddress,
                @Param("customerType") int customerType);

    @Query(value = "select * from customer where customer_id = :id", nativeQuery = true)
    Customer findById(@Param("id") int id);

    @Modifying
    @Query(value = "update customer set status = 1 where customer_id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Modifying
    @Query(value = "update customer set customer_code = :customerCode," +
            "customer_name = :customerName," +
            "customer_birthday = :customerBirthday," +
            "customer_gender = :customerGender ," +
            "customer_id_card = :customerIdCard ," +
            "customer_phone = :customerPhone," +
            "customer_email = :customerEmail," +
            "customer_address = :customerAddress," +
            "customer_type_id = :customerType where customer_id = :id", nativeQuery = true)
    void update(@Param("customerCode") String customerCode,
                @Param("customerName") String customerName,
                @Param("customerBirthday") String customerBirthday,
                @Param("customerGender") int customerGender,
                @Param("customerIdCard") String customerIdCard,
                @Param("customerPhone") String customerPhone,
                @Param("customerEmail") String customerEmail,
                @Param("customerAddress") String customerAddress,
                @Param("customerType") int customerType,
                @Param("id") int idCustomer);

}


