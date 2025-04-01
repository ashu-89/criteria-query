package com.ashu.criteria_query.repository;

import com.ashu.criteria_query.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

    Page<Orders> findAllByCustomerId(Long customerId, Pageable pageable);

}