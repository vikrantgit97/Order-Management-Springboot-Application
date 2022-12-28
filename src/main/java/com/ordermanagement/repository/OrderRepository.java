package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
