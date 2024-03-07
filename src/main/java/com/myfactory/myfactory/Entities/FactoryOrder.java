package com.myfactory.myfactory.Entities;

import java.util.List;

import com.myfactory.myfactory.Documentation.Documentation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class FactoryOrder extends EntityBase {

    @OneToMany(mappedBy = "order")
    @Documentation(description = "List of machines in this order")
    public List<Machine> machines;

    @ManyToOne
    @Documentation(description = "Customer who ordered this order")
    public Customer customer;
}
