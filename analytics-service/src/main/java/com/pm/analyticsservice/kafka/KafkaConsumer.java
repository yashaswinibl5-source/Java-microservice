package com.pm.analyticsservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumerEvent(String message) {
        try {
            Map<String, Object> event = objectMapper.readValue(message, Map.class);  //readvalue desialize json string into map and we need Map<String, Object> because value can be any type
            log.info("Received event from Kafka: {}", event);
        } catch (Exception e) {
            log.error("Failed to parse Kafka message: {}", message, e);
        }
    }
}