package com.myfactory.myfactory.Entities;

import java.util.List;

import com.myfactory.myfactory.Documentation.Documentation;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class Part extends EntityBase {
    @Documentation(description = "Part's name")
    public String name;
    @Documentation(description = "Part's description")
    public String description;

    @ManyToOne
    @Documentation(description = "Subassembly this part is a part of")
    public Subassembly subassembly;

    //some getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Subassembly getSubassembly() {
        return subassembly;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
