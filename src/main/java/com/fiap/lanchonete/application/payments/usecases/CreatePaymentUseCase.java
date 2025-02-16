package com.fiap.lanchonete.application.payments.usecases;

import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;

public class CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public CreatePaymentUseCase(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Payment createPayment(Payment payment) {

        return paymentGateway.save(payment);
    }
}
