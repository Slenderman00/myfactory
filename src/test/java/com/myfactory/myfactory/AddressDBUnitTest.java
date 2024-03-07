package com.myfactory.myfactory;

import com.myfactory.myfactory.Entities.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/*
 * This test, test the address entity.
 */
public class AddressDBUnitTest {

    @Test
    void testSetAddresses() {
        Address address1 = new Address();
        address1.setStreet("Karljohans gate");
        address1.setCity("Oslo");
        address1.setZipCode("00000");
        address1.setCountry("Norway");

        Address address2 = new Address();
        address2.setStreet("Alexanderplatz");
        address2.setCity("Berlin");
        address2.setZipCode("00001");
        address2.setCountry("Germany");


        assertEquals("Karljohans gate", address1.getStreet());
        assertEquals("Oslo", address1.getCity());
        assertEquals("00000", address1.getZipCode());
        assertEquals("Norway", address1.getCountry());

        assertEquals("Alexanderplatz", address2.getStreet());
        assertEquals("Berlin", address2.getCity());
        assertEquals("00001", address2.getZipCode());
        assertEquals("Germany", address2.getCountry());
    }
}
