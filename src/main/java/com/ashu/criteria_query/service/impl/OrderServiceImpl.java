package com.ashu.criteria_query.service.impl;


import com.ashu.criteria_query.model.Orders;
import com.ashu.criteria_query.repository.OrderRepo;
import com.ashu.criteria_query.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Page<Orders> getPastOrders(Long customerId, String search, Integer pageNo, Integer pageSize) {
        return orderRepo.findAllByCustomerId(customerId, PageRequest.of(pageNo, pageSize));
    }
}
