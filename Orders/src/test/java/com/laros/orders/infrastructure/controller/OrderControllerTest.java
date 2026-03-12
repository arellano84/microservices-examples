package com.laros.orders.infrastructure.controller;

import com.laros.orders.application.service.OrderApplicationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderApplicationService service;

    @Test
    void should_return_order_id_when_request_is_valid() throws Exception {
        Mockito.when(service.createOrder(Mockito.any()))
                .thenReturn("12345");

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\":\"Pedido test\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("12345"));
    }
}