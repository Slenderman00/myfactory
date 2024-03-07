package com.myfactory.myfactory.Entities;

import java.util.List;
import java.util.ArrayList;

import com.myfactory.myfactory.Documentation.Documentation;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Customer extends EntityBase {
    @Documentation(description = "Customer's name")
    public String name;
    @Documentation(description = "Customer's surname")
    public String surname;
    @Documentation(description = "Customer's email address")
    public String email;
    @Documentation(description = "Customer's phone number")
    public String phone;

    @OneToMany(mappedBy = "customer")
    public List<FactoryOrder> orders;
    
    @ManyToMany(mappedBy = "customers")
    public List<Address> addresses;

    //some getters and setters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<FactoryOrder> getOrders() {
        return orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrders(List<FactoryOrder> orders) {
        this.orders = orders;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void appendAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }

        this.addresses.add(address);
    }
}
