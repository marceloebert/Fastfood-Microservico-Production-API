package com.fiap.lanchonete;

import com.fiap.lanchonete.application.production.usecases.CreateOrderStatusUseCase;
import com.fiap.lanchonete.application.production.usecases.GetOrderStatusUseCase;
import com.fiap.lanchonete.application.production.usecases.UpdateOrderStatusUseCase;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import com.fiap.lanchonete.infrastructure.production.controller.dto.UpdateOrderStatusRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fiap.lanchonete.infrastructure.production.controller.ProductionApi;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductionApi.class)
class ProductionApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpdateOrderStatusUseCase updateOrderStatusUseCase;

    @MockBean
    private GetOrderStatusUseCase getOrderStatusUseCase;

    @MockBean
    private CreateOrderStatusUseCase createOrderStatusUseCase;

    @BeforeEach
    void setUp() {
        Mockito.when(getOrderStatusUseCase.execute("123")).thenReturn(Optional.of(OrderState.PENDING));
        Mockito.doNothing().when(updateOrderStatusUseCase).execute(any(), any());
        Mockito.when(getOrderStatusUseCase.execute(any())).thenReturn(Optional.of(OrderState.PENDING));
        Mockito.doNothing().when(createOrderStatusUseCase).execute(any(), any());
    }

  /*  @Test
    void testUpdateOrderStatus() throws Exception {
        String requestBody = "{\"state\": \"FINISHED\"}";

        mockMvc.perform(put("/production/123/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }*/

    /*@Test    
    void testGetOrderStatus() throws Exception {
        mockMvc.perform(get("/production/123/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("FINISHED"));
    }*/

    @Test
    void testCreateOrderStatus() throws Exception {
        mockMvc.perform(post("/production/123"))
                .andExpect(status().isOk())
                .andExpect(content().string("Status de produção criado com sucesso!"));
    }
}
