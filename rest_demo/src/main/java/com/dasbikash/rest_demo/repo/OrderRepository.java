package com.dasbikash.rest_demo.repo;

import com.dasbikash.rest_demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}