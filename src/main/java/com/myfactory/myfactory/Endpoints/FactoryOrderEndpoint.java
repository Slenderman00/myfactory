package com.myfactory.myfactory.Endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfactory.myfactory.Documentation.Documentation;
import com.myfactory.myfactory.Entities.FactoryOrder;
import com.myfactory.myfactory.Repositories.FactoryOrderRepository;

@RestController
@RequestMapping("/api/order")
@Documentation(path = "/api/order", description = "Operations on orders")
public class FactoryOrderEndpoint {
    private final FactoryOrderRepository repository;

    @Autowired
    public FactoryOrderEndpoint(FactoryOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    @Documentation(path = "api/order/all", description = "Get all orders", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/order/all?page=0&size=20&sort=customer,asc'")
    public Page<FactoryOrder> getAllFactoryOrders(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Documentation(path = "api/order/{id}", description = "Get order by ID")
    public FactoryOrder getFactoryOrderByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    @Documentation(path = "api/order/create", description = "Create order", method = "POST")
    public FactoryOrder createFactoryOrder(@RequestBody FactoryOrder factoryorder) {
        return repository.save(factoryorder);
    }

    @PutMapping("/update")
    @Documentation(path = "api/order/update", description = "Update order", method = "PUT")
    public FactoryOrder updateFactoryOrder(@RequestBody FactoryOrder factoryorder) {
        return repository.save(factoryorder);
    }

    @DeleteMapping("/delete/{id}")
    @Documentation(path = "api/order/delete/{id}", description = "Delete order by ID", method = "DELETE")
    public void deleteFactoryOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
