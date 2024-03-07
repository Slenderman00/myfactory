package com.myfactory.myfactory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfactory.myfactory.Entities.Address;
import com.myfactory.myfactory.Entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreet(String street);
    Address findByCity(String city);
    Address findByZipCode(String zipCode);
    Address findByCountry(String country);

    @Query("SELECT c FROM Customer c JOIN c.addresses a WHERE a.city = :city")
    List<Customer> findCustomersByCity(@Param("city") String city);
}
