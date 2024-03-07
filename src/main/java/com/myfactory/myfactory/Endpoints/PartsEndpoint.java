package com.myfactory.myfactory.Endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfactory.myfactory.Documentation.Documentation;
import com.myfactory.myfactory.Entities.Part;
import com.myfactory.myfactory.Repositories.PartRepository;

@RestController
@RequestMapping("/api/part")
@Documentation(path = "/api/part", description = "Operations on parts")
public class PartsEndpoint {
    private final PartRepository repository;

    @Autowired
    public PartsEndpoint(PartRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    @Documentation(path = "api/part/all", description = "Get all parts", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/part/all?page=0&size=20&sort=name,asc'")
    public Page<Part> getAllParts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Documentation(path = "api/part/{id}", description = "Get part by ID")
    public Part getPartByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    @Documentation(path = "api/part/create", description = "Create part", method = "POST")
    public Part createPart(@RequestBody Part part) {
        return repository.save(part);
    }

    @PutMapping("/update")
    @Documentation(path = "api/part/update", description = "Update part", method = "PUT")
    public Part updatePart(@RequestBody Part part) {
        return repository.save(part);
    }

    @DeleteMapping("/delete/{id}")
    @Documentation(path = "api/part/delete/{id}", description = "Delete part by ID", method = "DELETE")
    public void deletePart(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
