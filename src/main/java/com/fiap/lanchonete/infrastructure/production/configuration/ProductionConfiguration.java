package com.fiap.lanchonete.infrastructure.production.configuration;

import com.fiap.lanchonete.application.production.gateways.ProductionGateway;
import com.fiap.lanchonete.application.production.gateways.ProductionGatewayImpl;
import com.fiap.lanchonete.infrastructure.production.repository.ProductionStatusRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductionConfiguration {

    @Bean
    public ProductionGateway productionGateway(ProductionStatusRepository productionStatusRepository) {
        return new ProductionGatewayImpl(productionStatusRepository);
    }
}
