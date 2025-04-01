package com.ashu.criteria_query.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    String name;
    String address;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    List<Orders> orders;
}
