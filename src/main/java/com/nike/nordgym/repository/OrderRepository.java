package com.nike.nordgym.repository;

import com.nike.nordgym.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByIsOpen(boolean isOpen);

    @Query("select order from Order order where order.user.id = :id")
    List<Order> findAllByUserId(@Param("id") Long id);

}
