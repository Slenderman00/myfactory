package com.myfactory.myfactory.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.ArrayList;

import com.myfactory.myfactory.Documentation.Documentation;


@Entity
public class Subassembly extends EntityBase {

    @Documentation(description = "Subassembly's name")
    public String name;

    @Documentation(description = "Subassembly's description")
    public String description;

    @ManyToOne
    @Documentation(description = "Machine this subassembly is a part of")
    public Machine machine;
    
    @OneToMany(mappedBy = "subassembly")
    @Documentation(description = "List of parts in this subassembly")
    public List<Part> parts;

    //some getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Machine getMachine() {
        return machine;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void appendPart(Part part) {
        if (this.parts == null) {
            this.parts = new ArrayList<Part>();
        }
        this.parts.add(part);
    }
}

