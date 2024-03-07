package com.myfactory.myfactory.Entities;

import java.util.List;
import java.util.ArrayList;

import com.myfactory.myfactory.Documentation.Documentation;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Machine extends EntityBase {
    @Documentation(description = "Machine's name")
    private String name;
    @Documentation(description = "Machine's description")
    private String description;

    @ManyToOne
    @Documentation(description = "Order this machine is a part of")
    public FactoryOrder order;

    @OneToMany(mappedBy = "machine")
    @Documentation(description = "List of subassemblies in this machine")
    public List<Subassembly> subassemblies;

    //some getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FactoryOrder getOrder() {
        return order;
    }

    public List<Subassembly> getSubassemblies() {
        return subassemblies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrder(FactoryOrder order) {
        this.order = order;
    }

    public void setSubassemblies(List<Subassembly> subassemblies) {
        this.subassemblies = subassemblies;
    }

    public void appendSubassembly(Subassembly subassembly) {
        if (this.subassemblies == null) {
            this.subassemblies = new ArrayList<>();
        }
        this.subassemblies.add(subassembly);
    }
}
