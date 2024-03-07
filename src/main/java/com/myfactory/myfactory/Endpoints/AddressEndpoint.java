package com.myfactory.myfactory.Endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfactory.myfactory.Documentation.AppendField;
import com.myfactory.myfactory.Documentation.Documentation;
import com.myfactory.myfactory.Entities.Address;
import com.myfactory.myfactory.Repositories.AddressRepository;
import com.myfactory.myfactory.Entities.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@Documentation(path = "/api/address", description = "Operations on addresses")
public class AddressEndpoint {
    private final AddressRepository repository;

    @Autowired
    public AddressEndpoint(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-by-city/{city}")
    @Documentation(path = "api/address/all-by-city/{city}", description = "Fetch customers by city", example = "curl -H \"Content-type: application/json\" 'http://127:0.0.1:8080/api/address/all-by-city/{city}'")
    @AppendField(name = "street", description = "Street of the address", type = String.class)
    @AppendField(name = "city", description = "City of the address", type = String.class)
    @AppendField(name = "zipCode", description = "Zip code of the address", type = String.class)
    @AppendField(name = "country", description = "Country of the address", type = String.class)
    @AppendField(name = "customers", description = "Customers of the address", type = List.class)
    @AppendField(name = "id", description = "ID of the address", type = Long.class)
    public List<Customer> getCustomerByCity(String city) {
        return repository.findCustomersByCity(city);
    }

    @GetMapping("/all")
    @Documentation(path = "api/address/all", description = "Get all addresses", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/address/all?page=0&size=20&sort=street,asc'")
    @AppendField(name = "street", description = "Street of the address", type = String.class)
    @AppendField(name = "city", description = "City of the address", type = String.class)
    @AppendField(name = "zipCode", description = "Zip code of the address", type = String.class)
    @AppendField(name = "country", description = "Country of the address", type = String.class)
    @AppendField(name = "customers", description = "Customers of the address", type = List.class)
    @AppendField(name = "id", description = "ID of the address", type = Long.class)
    public Page<Address> getAllAddresses(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Documentation(path = "api/address/{id}", description = "Get address by ID", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/address/{id}'")
    public Address getAddressByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    @Documentation(path = "api/address/create", description = "Create address", method = "POST", example = "curl -X POST -H \"Content-type: application/json\" -d '{\"street\":\"some street\",\"city\":\"some city\",\"zipCode\":\"some zip code\",\"country\":\"some country\"}' 'http://127.0.0.1:8080/api/address/create'")
    public Address createAddress(@RequestBody Address address) {
        return repository.save(address);
    }

    @PutMapping("/update")
    @Documentation(path = "api/address/update", description = "Update address", method = "PUT")
    public Address updateAddress(@RequestBody Address address) {
        return repository.save(address);
    }

    @DeleteMapping("/delete/{id}")
    @Documentation(path = "api/address/delete/{id}", description = "Delete address by ID", method = "DELETE", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/address/delete/{id}'")
    public void deleteAddress(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
