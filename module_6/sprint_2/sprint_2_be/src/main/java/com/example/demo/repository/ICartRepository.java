package com.example.demo.repository;

import com.example.demo.dto.ICartDto;
import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = " select c.* from cart c " +
            " join customer cu on cu.id = c.customer_id " +
            " join product p on c.id_product = p.id  " +
            " where  c.customer_id = :#{#customer.id} and c.bill_id is null  ", nativeQuery = true)
    List<Cart> displayProductInCart(Customer customer);


    @Transactional
    @Modifying
    @Query(value = " DELETE FROM `cart` WHERE `id_product` = :idKey", nativeQuery = true)
    void deleteByIdProduct(@Param("idKey") Integer id);

    @Query(value = " select * from cart " +
            " join product on cart.id_product = product.id" +
            " join customer on cart.customer_id = customer.id " +
            " where cart.id_product = :#{#cart.product.id} " +
            " and cart.customer_id = :#{#cart.customer.id} " +
            " and cart.bill_id is null ", nativeQuery = true)
    Cart findProductOrderListByCustomerAndProduct(Cart cart);


    @Query(value = " select po.* from cart po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.id_product " +
            " where po.customer_id = :#{#customer.id} " +
            " and bill_id is null ", nativeQuery = true)
    List<Cart> displayProductInCartByCustomer(Customer customer);
}
