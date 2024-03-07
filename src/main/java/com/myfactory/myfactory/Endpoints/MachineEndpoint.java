package com.myfactory.myfactory.Endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfactory.myfactory.Documentation.Documentation;
import com.myfactory.myfactory.Entities.Machine;
import com.myfactory.myfactory.Repositories.MachineRepository;

@RestController
@RequestMapping("/api/machine")
@Documentation(path = "/api/machine", description = "Operations on machines")
public class MachineEndpoint {
    private final MachineRepository repository;

    @Autowired
    public MachineEndpoint(MachineRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    @Documentation(path = "api/machine/all", description = "Get all machines", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/machine/all?page=0&size=20&sort=name,asc'")
    public Page<Machine> getAllMachines(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Documentation(path = "api/machine/{id}", description = "Get machine by ID")
    public Machine getMachineByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    @Documentation(path = "api/machine/create", description = "Create machine", method = "POST")
    public Machine createMachine(@RequestBody Machine machine) {
        return repository.save(machine);
    }

    @PutMapping("/update")
    @Documentation(path = "api/machine/update", description = "Update machine", method = "PUT")
    public Machine updateMachine(@RequestBody Machine machine) {
        return repository.save(machine);
    }

    @DeleteMapping("/delete/{id}")
    @Documentation(path = "api/machine/delete/{id}", description = "Delete machine by ID", method = "DELETE")
    public void deleteMachine(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
