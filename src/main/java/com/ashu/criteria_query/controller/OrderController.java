package com.ashu.criteria_query.controller;

import com.ashu.criteria_query.model.Orders;
import com.ashu.criteria_query.service.OrderService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<Orders>> getOrders(
            @RequestParam("customerId") Long customerId,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "pageNo", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", required = false) Integer pageSize ) {

        if( pageNo == null || StringUtils.isBlank(pageNo.toString())) {
            pageNo = 0;
        }

        if( pageSize == null || StringUtils.isBlank(pageSize.toString())) {
            pageSize = 10;
        }

        Page<Orders> responseList = orderService.getPastOrders(customerId, search, pageNo, pageSize);
        return new ResponseEntity<>(responseList, HttpStatus.OK);

    }
}
