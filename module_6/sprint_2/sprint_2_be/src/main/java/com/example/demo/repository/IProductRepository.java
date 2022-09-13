package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = " select * from product " +
            "where id_category = 1 and `name` like :nameLaptop and `name` like :nameSearch and price_sale  BETWEEN :beforePrice and :afterPrice and is_delete = 0   ",
            countQuery = " select count(*) from ( select * from product " +
                    "where id_category = 1 and `name` like :nameLaptop and `name` like :nameSearch and price_sale BETWEEN :beforePrice and :afterPrice and is_delete = 0  ) temp ",
            nativeQuery = true)
    Page<Product> searchPriceAndNameLaptop(Pageable pageable,
                                           @Param("nameLaptop") String nameLaptop,
                                           @Param("nameSearch") String nameSearch,
                                           @Param("beforePrice") Double beforePrice,
                                           @Param("afterPrice") Double afterPrice);


    @Query(value = " select * from product " +
            "where id_category = 2 and `name` like :namePhone and `name` like :nameSearch and price_sale  BETWEEN :beforePrice and :afterPrice and is_delete = 0   ",
            countQuery = " select count(*) from ( select * from product " +
                    "where id_category = 2 and `name` like :namePhone and `name` like :nameSearch and price_sale BETWEEN :beforePrice and :afterPrice and is_delete = 0  ) temp ",
            nativeQuery = true)
    Page<Product> searchPriceAndNamePhone(Pageable pageable,
                                          @Param("namePhone") String namePhone,
                                          @Param("nameSearch") String nameSearch,
                                          @Param("beforePrice") Double beforePrice,
                                          @Param("afterPrice") Double afterPrice);


    @Query(value = " SELECT id, cost, `create_date`, `image`," +
            " `is_delete`, `made_in`, `name`," +
            " `price`,`price_sale`,`specifications` ,`status_product`,id_category " +
            " FROM product " +
            " ORDER BY ABS( DATEDIFF( create_date, NOW() ) ) limit 8 ",
            nativeQuery = true)
    List<Product> getProductNearTheDay();


}
