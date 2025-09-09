package com.marcelomnzs.course.repositories;

import com.marcelomnzs.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
