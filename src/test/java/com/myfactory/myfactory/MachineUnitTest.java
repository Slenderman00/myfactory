package com.myfactory.myfactory;

import com.myfactory.myfactory.Entities.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.myfactory.myfactory.Entities.Machine;
import com.myfactory.myfactory.Entities.Part;
import com.myfactory.myfactory.Entities.Subassembly;


/*
 * This test, test the address entity.
 */
public class MachineUnitTest {

    @Test
    void testMachineSetGet() {
        Machine machine = new Machine();
        machine.setName("Machine 1");
        machine.setDescription(null);

        Part part1 = new Part();
        part1.setName("Part 1");
        part1.setDescription("Part 1 description");
        
        Part part2 = new Part();
        part2.setName("Part 2");
        part2.setDescription("Part 2 description");

        Subassembly subassembly1 = new Subassembly();
        subassembly1.setName("Subassembly 1");
        subassembly1.setDescription("Subassembly 1 description");

        Subassembly subassembly2 = new Subassembly();
        subassembly2.setName("Subassembly 2");
        subassembly2.setDescription("Subassembly 2 description");

        subassembly1.appendPart(part2);
        subassembly2.appendPart(part1);

        machine.appendSubassembly(subassembly1);
        machine.appendSubassembly(subassembly2);

        assertEquals("Machine 1", machine.getName());
        assertEquals(null, machine.getDescription());

        assertEquals("Part 1", machine.getSubassemblies().get(1).getParts().get(0).getName());
        assertEquals("Part 2", machine.getSubassemblies().get(0).getParts().get(0).getName());

        assertEquals("Subassembly 1", machine.getSubassemblies().get(0).getName());
        assertEquals("Subassembly 2", machine.getSubassemblies().get(1).getName());

        assertEquals("Subassembly 1 description", machine.getSubassemblies().get(0).getDescription());
        assertEquals("Subassembly 2 description", machine.getSubassemblies().get(1).getDescription());

        assertEquals("Part 1 description", machine.getSubassemblies().get(1).getParts().get(0).getDescription());
        assertEquals("Part 2 description", machine.getSubassemblies().get(0).getParts().get(0).getDescription());

        assertEquals("Part 1", machine.getSubassemblies().get(1).getParts().get(0).getName());
        assertEquals("Part 2", machine.getSubassemblies().get(0).getParts().get(0).getName());
    }
}
