package com.techreturners.apilab1.controller;

//package definition omitted for brevity
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@AutoConfigureMockMvc
@SpringBootTest
public class HomeControllerTests {
    @Autowired
    private MockMvc mockMvcController;
    @Test
    public void testGetHome() throws Exception {
        String expectedContent = "Welcome to the Drinks API!";
        this.mockMvcController.perform(
        MockMvcRequestBuilders.get("/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(expectedContent
        ));
    }

//    @Autowired
//    private MockMvc mockMvcController;
    @Test
    public void testCoffeeLoverEndpoint() throws Exception {
        String expectedContent = "I like coffee!";
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffeelover"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(expectedContent
        ));
    }

    @Test
    public void testCoffeeEndpointReturnCappuccino() throws Exception {
        String expectedValue = "cappuccino";

        mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee").param("name", "cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }

    @Test
    public void testCoffeeEndpointReturnLatte() throws Exception {
        String expectedValue = "latte";

        mockMvcController.perform(MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }
}

