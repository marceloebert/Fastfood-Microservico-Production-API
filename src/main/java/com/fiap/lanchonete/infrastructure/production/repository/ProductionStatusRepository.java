package com.fiap.lanchonete.infrastructure.production.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductionStatusRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public ProductionStatusRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Optional<String> getOrderState(String orderId) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(orderId)); // ✅ Retorna String
    }

    public void updateOrderState(String orderId, String state) {
        redisTemplate.opsForValue().set(orderId, state); // ✅ Salva como String
    }

    public void createOrderState(String orderId, String initialState) {
        redisTemplate.opsForValue().set(orderId, initialState);
    }
}
