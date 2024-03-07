package com.myfactory.myfactory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfactory.myfactory.Entities.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    Machine findByName(String name);
}
