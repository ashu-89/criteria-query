package com.ashu.criteria_query.service;

import com.ashu.criteria_query.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Page<Orders> getPastOrders(Long customerId, String search, Integer pageNo, Integer pageSize);
}
