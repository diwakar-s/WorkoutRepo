package com.delivery.challenge.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.challenge.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}