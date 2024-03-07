package com.myfactory.myfactory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfactory.myfactory.Entities.Subassembly;

public interface SubassemblyRepository extends JpaRepository<Subassembly, Long> {
    Subassembly findByName(String name);
    Subassembly findByDescription(String description);
}