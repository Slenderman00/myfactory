package com.myfactory.myfactory;

import net.minidev.json.JSONObject;

import com.myfactory.myfactory.Entities.Customer;

import com.myfactory.myfactory.Entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.HttpStatus;

/*
 * This test, test the customer endpoint.
 * This is an end to end test, and it tests multiple user-related api endpoints. 
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerEndpointIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateCustomerWithAddress() {
        // Step 1: Create an address
        JSONObject addressJson = new JSONObject();
        addressJson.put("street", "some street");
        addressJson.put("city", "some city");
        addressJson.put("zipCode", "some zip code");
        addressJson.put("country", "some country");
    
        ResponseEntity<Address> addressResponse = restTemplate.postForEntity("/api/address/create", addressJson, Address.class);

        assertEquals(HttpStatus.OK, addressResponse.getStatusCode());
        assertNotNull(addressResponse.getBody());

        Address savedAddress = addressResponse.getBody();
        JSONObject customerJson = new JSONObject();
        customerJson.put("name", "John Doe");
        customerJson.put("surname", "John Doe");
        customerJson.put("email", "John Doe");
        customerJson.put("phone", "John Doe");

        customerJson.put("address", savedAddress); 


        ResponseEntity<Customer> customerResponse = restTemplate.postForEntity("/api/customer/create", customerJson, Customer.class);

        assertEquals(HttpStatus.OK, customerResponse.getStatusCode());
        assertNotNull(customerResponse.getBody());
        

        //now do a request to the get all customers endpoint and check if the customer is there
        ResponseEntity<String> response = restTemplate.getForEntity("/api/customer/all", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("John Doe"));

        //now we are going to change the address of the customer
        JSONObject addressJson2 = new JSONObject();
        addressJson2.put("street", "some street2");
        addressJson2.put("city", "some city2");
        addressJson2.put("zipCode", "some zip code2");
        addressJson2.put("country", "some country2");

        ResponseEntity<Address> addressResponse2 = restTemplate.postForEntity("/api/address/create", addressJson2, Address.class);

        assertEquals(HttpStatus.OK, addressResponse2.getStatusCode());
        assertNotNull(addressResponse2.getBody());

        Address savedAddress2 = addressResponse2.getBody();
        JSONObject customerJson2 = new JSONObject();
        customerJson2.put("name", "John Doe2");
        customerJson2.put("surname", "John Doe2");
        customerJson2.put("email", "John Doe2");
        customerJson2.put("phone", "John Doe2");

        customerJson2.put("address", savedAddress2);

        ResponseEntity<Customer> customerResponse2 = restTemplate.postForEntity("/api/customer/create", customerJson2, Customer.class);

        assertEquals(HttpStatus.OK, customerResponse2.getStatusCode());
        assertNotNull(customerResponse2.getBody());

        //now do a request to the get all customers endpoint and check if the customer is there
        ResponseEntity<String> response2 = restTemplate.getForEntity("/api/customer/all", String.class);

        assertEquals(HttpStatus.OK, response2.getStatusCode());
        assertTrue(response2.getBody().contains("John Doe2"));
    }
}