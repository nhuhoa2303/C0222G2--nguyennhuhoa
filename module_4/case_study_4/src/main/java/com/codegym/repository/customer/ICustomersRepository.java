package com.codegym.repository.customer;

import com.codegym.model.customers.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomersRepository extends JpaRepository<Customer, Integer> {


    @Query(value = " select * from customer where name_customer like :key ",
    countQuery = " select count(*) from ( select * from customer where name_customer like :key) temp ", nativeQuery = true)
    Page<Customer> displayAllAndDisplayByNameSearch(@Param("key")String nameSearch, Pageable pageable);

//    Page<Customer> findAll(Pageable pageable);
    @Query(value= "select * from customer where id = :id", nativeQuery = true)
    Customer displayAllById(@Param("id") Integer id);
}
