package com.ashu.criteria_query.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name="orders")
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    Double amount;
    Date date;


}
