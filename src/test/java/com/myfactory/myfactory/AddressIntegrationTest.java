package com.myfactory.myfactory;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

import com.myfactory.myfactory.Entities.Address;
import com.myfactory.myfactory.Repositories.AddressRepository;

/*
 * This test, test the get all addresses endpoint. 
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AddressRepository repository;

    @BeforeEach
    void populateDatabase() {
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

        repository.save(address1);
        repository.save(address2);
    }
    
    @Test
    void testGetAddresses() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/address/all", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("Karljohans gate"));
        assertTrue(response.getBody().contains("Oslo"));
        assertTrue(response.getBody().contains("00000"));
        assertTrue(response.getBody().contains("Norway"));
        assertTrue(response.getBody().contains("Alexanderplatz"));
        assertTrue(response.getBody().contains("Berlin"));
        assertTrue(response.getBody().contains("00001"));
        assertTrue(response.getBody().contains("Germany"));
    }
}
