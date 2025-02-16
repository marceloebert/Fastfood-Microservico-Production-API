package com.fiap.lanchonete.infrastructure.payments.configuration;

import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCase;
import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.application.payments.usecases.ApprovePaymentUseCase;
import com.fiap.lanchonete.application.payments.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.infrastructure.payments.controller.mapper.PaymentDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfiguration {

    private final PaymentGateway paymentGateway;
    private final UpdateOrderStateUseCase updateOrderStateUseCase;

    public PaymentConfiguration(PaymentGateway paymentGateway, UpdateOrderStateUseCase updateOrderStateUseCase) {
        this.paymentGateway = paymentGateway;
        this.updateOrderStateUseCase = updateOrderStateUseCase;
    }

    @Bean
    public CreatePaymentUseCase createPaymentUseCase() {
        return new CreatePaymentUseCase(paymentGateway);
    }

    @Bean
    public ApprovePaymentUseCase approvePaymentUseCase() {
        return new ApprovePaymentUseCase(paymentGateway, updateOrderStateUseCase);
    }

    @Bean
    public PaymentDTOMapper paymentDTOMapper() {
        return new PaymentDTOMapper();
    }
}
