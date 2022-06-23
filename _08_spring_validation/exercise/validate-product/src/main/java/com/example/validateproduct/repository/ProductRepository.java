package com.example.validateproduct.repository;

import com.example.validateproduct.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query(value = "select * from product where status = 0", nativeQuery = true)
    Page<Product> findAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into product (name_product,price_product,detail_product,production) " +
            "values (:nameProduct,:priceProduct,:detailProduct,:production)", nativeQuery = true)
    void create(@Param("nameProduct") String nameProduct,
                @Param("priceProduct") double priceProduct,
                @Param("detailProduct") String detailProduct,
                @Param("production") String production);

    @Modifying
    @Query(value = "update product set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findById(@Param("id") int id);

    @Modifying
    @Query(value = "update product set name_product = :nameProduct, price_product = :priceProduct, detail_product = :detailProduct, production = :production " +
            "where id = :id", nativeQuery = true)
    void update(@Param("nameProduct") String nameProduct,
                @Param("priceProduct") double priceProduct,
                @Param("detailProduct") String detailProduct,
                @Param("production") String production,
                @Param("id") int id
    );

    @Query(value = "select * from product where name_product like %:nameProduct% and status = 0", nativeQuery = true)
    Page<Product> search(@Param("nameProduct") String nameProduct, Pageable pageable);

}
