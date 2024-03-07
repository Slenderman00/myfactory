package com.myfactory.myfactory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfactory.myfactory.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByPhone(String phone);
}
