package com.myfactory.myfactory.Endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfactory.myfactory.Documentation.AppendField;
import com.myfactory.myfactory.Documentation.Documentation;
import com.myfactory.myfactory.Entities.Address;
import com.myfactory.myfactory.Entities.Customer;
import com.myfactory.myfactory.Repositories.CustomerRepository;
import com.myfactory.myfactory.Repositories.AddressRepository;
import com.myfactory.myfactory.Repositories.CustomerDataTransferObject;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Documentation(path = "/api/customer", description = "Operations on customers")
public class CustomerEndpoint {
    private final CustomerRepository repository;
    private final AddressRepository addressRepository;

    @Autowired
    public CustomerEndpoint(CustomerRepository repository, AddressRepository addressRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/all")
    @Documentation(path = "api/customer/all", description = "Get all customers", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/customer/all?page=0&size=20&sort=firstName,asc'")
    @AppendField(name = "firstName", description = "First name of the customer", type = String.class)
    @AppendField(name = "lastName", description = "Last name of the customer", type = String.class)
    @AppendField(name = "email", description = "Email of the customer", type = String.class)
    @AppendField(name = "phone", description = "Phone of the customer", type = String.class)
    @AppendField(name = "addresses", description = "Addresses of the customer", type = List.class)
    @AppendField(name = "id", description = "ID of the customer", type = Long.class)
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Documentation(path = "api/customer/{id}", description = "Get customer by ID")
    public Customer getCustomerByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/create-with-address")
    @Documentation(path = "api/customer/create-with-address", description = "Create customer with address (documentation is missing all address fields)", method = "POST", example = "curl -X POST -H \"Content-type: application/json\" -d '{\"name\":\"some name\",\"surname\":\"some surname\",\"email\":\"some email\",\"phone\":\"some phone\",\"street\":\"some street\",\"city\":\"some city\",\"zipCode\":\"some zip code\",\"country\":\"some country\"}' 'http://127.0.0.1:8080/api/customer/create-with-address'")
    @AppendField(name = "address", description = "Address of the customer", type = Address.class)
    @AppendField(name = "street", description = "Street of the customer", type = String.class)
    @AppendField(name = "city", description = "City of the customer", type = String.class)
    @AppendField(name = "zipCode", description = "Zip code of the customer", type = String.class)
    @AppendField(name = "country", description = "Country of the customer", type = String.class)
    public Customer createCustomerWithAddress(CustomerDataTransferObject customerDataTransferObject) {
        Customer customer = new Customer();
        customer.setName(customerDataTransferObject.getName());
        customer.setSurname(customerDataTransferObject.getSurname());
        customer.setEmail(customerDataTransferObject.getEmail());
        customer.setPhone(customerDataTransferObject.getPhone());

        Address address = new Address();
        
        address.setStreet(customerDataTransferObject.getStreet());
        address.setCity(customerDataTransferObject.getCity());
        address.setZipCode(customerDataTransferObject.getZipCode());
        address.setCountry(customerDataTransferObject.getCountry());

        address.appendCustomer(customer);
        customer.appendAddress(address);

        return repository.save(customer);
    }

    @PostMapping("/create")
    @Documentation(path = "api/customer/create", description = "Create customer", method = "POST")
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @PutMapping("/update")
    @Documentation(path = "api/customer/update", description = "Update customer", method = "PUT")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    @Documentation(path = "api/customer/delete/{id}", description = "Delete customer by ID", method = "DELETE")
    public void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}