package com.whs.kafkademo.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    @KafkaListener(topics = "test")
    public void listener(ConsumerRecord<?, ?> record) {
        System.out.println(String.format("topic:%s, offset:%d, value:%s ", record.topic(), record.offset(), record.value()));
    }
}
