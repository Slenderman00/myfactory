package com.myfactory.myfactory.Endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfactory.myfactory.Documentation.Documentation;
import com.myfactory.myfactory.Entities.Subassembly;
import com.myfactory.myfactory.Repositories.SubassemblyRepository;

@RestController
@RequestMapping("/api/subassembly")
@Documentation(path = "/api/subassembly", description = "Operations on subassemblies")
public class SubassemblyEndpoint {
    private final SubassemblyRepository repository;

    @Autowired
    public SubassemblyEndpoint(SubassemblyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    @Documentation(path = "api/subassembly/all", description = "Get all subassemblies", example = "curl -H \"Content-type: application/json\" 'http://127.0.0.1:8080/api/subassembly/all?page=0&size=20&sort=name,asc'")
    public Page<Subassembly> getAllSubassemblies(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Documentation(path = "api/subassembly/{id}", description = "Get subassembly by ID")
    public Subassembly getSubassemblyByID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    @Documentation(path = "api/subassembly/create", description = "Create subassembly", method = "POST")
    public Subassembly createSubassembly(@RequestBody Subassembly subassembly) {
        return repository.save(subassembly);
    }

    @PutMapping("/update")
    @Documentation(path = "api/subassembly/update", description = "Update subassembly", method = "PUT")
    public Subassembly updateSubassembly(@RequestBody Subassembly subassembly) {
        return repository.save(subassembly);
    }

    @DeleteMapping("/delete/{id}")
    @Documentation(path = "api/subassembly/delete/{id}", description = "Delete subassembly by ID", method = "DELETE")
    public void deleteSubassembly(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
