package com.myfactory.myfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FactoryOrderEndpointTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllFactoryOrders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/order/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateFactoryOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/order/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\": \"Test Order\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateFactoryOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/order/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\": \"Updated Order\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteFactoryOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/order/delete/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}