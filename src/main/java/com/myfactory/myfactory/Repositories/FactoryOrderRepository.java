package com.myfactory.myfactory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfactory.myfactory.Entities.FactoryOrder;

public interface FactoryOrderRepository extends JpaRepository<FactoryOrder, Long> {
    FactoryOrder findByCustomer_Name(String customerName);
    FactoryOrder findByMachines_Name(String machineName);
}