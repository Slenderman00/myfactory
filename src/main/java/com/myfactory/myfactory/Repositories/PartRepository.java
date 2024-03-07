package com.myfactory.myfactory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfactory.myfactory.Entities.Part;

public interface PartRepository extends JpaRepository<Part, Long> {
    Part findByName(String name);
    Part findByDescription(String description);
}
