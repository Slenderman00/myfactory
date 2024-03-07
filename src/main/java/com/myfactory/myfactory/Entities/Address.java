package com.myfactory.myfactory.Entities;

import com.myfactory.myfactory.Documentation.Documentation;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Address extends EntityBase {

    @Documentation(description = "Street name")
    public String street;
    @Documentation(description = "City name")
    public String city;
    @Documentation(description = "Zip code")
    public String zipCode;
    @Documentation(description = "Country name")
    public String country;

    @ManyToMany
    @Documentation(description = "Customers living at this address")
    public List<Customer> customers;

    //some getters and setters
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void appendCustomer(Customer customer) {
        if (this.customers == null) {
            this.customers = new ArrayList<>();
        }

        this.customers.add(customer);
    }
}

